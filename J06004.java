import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String phone;
    private int groupId;
    private Nhom group;

    public SinhVien(String id, String name, String phone, int groupId) {
        this.id = id;
        this.name = name.trim();
        this.phone = phone;
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroup(Nhom group) {
        this.group = group;
    }

    @Override
    public int compareTo(SinhVien o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s", id, name, phone, groupId, group.getDeTai());
    }
}

class Nhom {
    private static int ID = 0;
    private int id;
    private String deTai;

    public Nhom(String deTai) {
        id = ++ID;
        this.deTai = deTai;
    }

    public int getId() {
        return id;
    }

    public String getDeTai() {
        return deTai;
    }
}

public class J06004 {
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
        Collections.sort(a);
        ArrayList<Nhom> b = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < m; ++i) b.add(new Nhom(sc.nextLine()));
        for (SinhVien x : a)
            for (Nhom y : b)
                if (x.getGroupId() == y.getId()) x.setGroup(y);
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}