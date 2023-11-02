import java.util.ArrayList;
import java.util.Scanner;

class SinhVien {
    private String id;
    private String name;
    private String phone;
    private int groupId;

    public SinhVien(String id, String name, String phone, int groupId) {
        this.id = id;
        this.name = name.trim();
        this.phone = phone;
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, name, phone);
    }
}

class Nhom {
    private static int ID = 0;
    private int id;
    private String deTai;
    private ArrayList<SinhVien> sinhViens;

    public Nhom(String deTai) {
        id = ++ID;
        this.deTai = deTai;
        sinhViens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<SinhVien> getSinhViens() {
        return sinhViens;
    }

    @Override
    public String toString() {
        String s = String.format("DANH SACH NHOM %d:\n", id);
        for (SinhVien x : sinhViens) s += (x.toString() + "\n");
        s += String.format("Bai tap dang ky: %s", deTai);
        return s;
    }
}

public class J06003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.next();
            int groupId = sc.nextInt();
            a.add(new SinhVien(id, name, phone, groupId));
        }
        ArrayList<Nhom> b = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < m; ++i) b.add(new Nhom(sc.nextLine()));
        for (SinhVien x : a)
            for (Nhom y : b)
                if (x.getGroupId() == y.getId()) y.getSinhViens().add(x);
        int q = sc.nextInt();
        while (q-- > 0) {
            int id = sc.nextInt();
            for (Nhom x : b)
                if (x.getId() == id) System.out.println(x);
        }
        sc.close();
    }
}