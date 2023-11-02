import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String phone;
    private Nhom nhom;

    public SinhVien(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setNhom(Nhom nhom) {
        this.nhom = nhom;
    }

    @Override
    public int compareTo(SinhVien o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s", id, name, phone, nhom.getId(), nhom.getHomeWork());
    }
}

class Nhom {
    private int id;
    private String homeWork;

    public Nhom(int id, String homeWork) {
        this.id = id;
        this.homeWork = homeWork;
    }

    public int getId() {
        return id;
    }

    public String getHomeWork() {
        return homeWork;
    }
}

public class J07027 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("BAITAP.in"));
        Scanner sc3 = new Scanner(new File("NHOM.in"));
        int n = sc1.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            String phone = sc1.next();
            a.add(new SinhVien(id, name, phone));
        }
        int m = sc2.nextInt();
        sc2.nextLine();
        ArrayList<Nhom> b = new ArrayList<>();
        for (int i = 1; i <= m; ++i) b.add(new Nhom(i, sc2.nextLine()));
        for (int i = 0; i < n; ++i) {
            String sinhVienId = sc3.next();
            int groupId = sc3.nextInt();
            for (SinhVien x : a)
                if (x.getId().equals(sinhVienId)) {
                    for (Nhom y : b)
                        if (y.getId() == groupId) {
                            x.setNhom(y);
                            break;
                        }
                    break;
                }
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
