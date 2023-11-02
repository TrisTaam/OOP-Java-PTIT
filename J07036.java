import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;
    private int numOfCredits;

    public MonHoc(String id, String name, int numOfCredits) {
        this.id = id;
        this.name = name;
        this.numOfCredits = numOfCredits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private String mail;

    public SinhVien(String id, String name, String grade, String mail) {
        this.id = id;
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.grade = grade;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

class BangDiem implements Comparable<BangDiem> {
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private double mark;

    public BangDiem(double mark) {
        this.mark = mark;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    @Override
    public int compareTo(BangDiem o) {
        if (!monHoc.getId().equals(o.monHoc.getId())) return monHoc.getId().compareTo(o.monHoc.getId());
        return sinhVien.getId().compareTo(o.sinhVien.getId());
    }

    @Override
    public String toString() {
        String s = String.format("%s %s %s %s ", sinhVien.getId(), sinhVien.getName(), monHoc.getId(), monHoc.getName());
        if (mark == (int) mark) s += String.format("%d", (int) mark);
        else s += String.format("%s", mark);
        return s;
    }
}

public class J07036 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("MONHOC.in"));
        Scanner sc3 = new Scanner(new File("BANGDIEM.in")).useLocale(Locale.getDefault());
        int n = sc1.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            String grade = sc1.next();
            String mail = sc1.next();
            a.add(new SinhVien(id, name, grade, mail));
        }
        int m = sc2.nextInt();
        sc2.nextLine();
        ArrayList<MonHoc> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String id = sc2.next();
            sc2.nextLine();
            String name = sc2.nextLine();
            int numOfCredits = sc2.nextInt();
            b.add(new MonHoc(id, name, numOfCredits));
        }
        int k = sc3.nextInt();
        ArrayList<BangDiem> c = new ArrayList<>();
        while (k-- > 0) {
            String sinhVienId = sc3.next();
            String monHocId = sc3.next();
            double mark = sc3.nextDouble();
            BangDiem d = new BangDiem(mark);
            for (SinhVien x : a)
                if (x.getId().equals(sinhVienId)) {
                    d.setSinhVien(x);
                    break;
                }
            for (MonHoc x : b)
                if (x.getId().equals(monHocId)) {
                    d.setMonHoc(x);
                    break;
                }
            c.add(d);
        }
        Collections.sort(c);
        k = sc3.nextInt();
        while (k-- > 0) {
            String grade = sc3.next();
            System.out.printf("BANG DIEM lop %s:\n", grade);
            for (BangDiem x : c)
                if (x.getSinhVien().getGrade().equals(grade)) System.out.println(x);
        }
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
