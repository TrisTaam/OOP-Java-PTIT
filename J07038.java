import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
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

    @Override
    public int compareTo(SinhVien o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, name, grade);
    }
}

class DoanhNghiep {
    private String id;
    private String name;
    private int numOfAvailableStudents;
    private ArrayList<SinhVien> sinhViens;

    public DoanhNghiep(String id, String name, int numOfAvailableStudents) {
        this.id = id;
        this.name = name;
        this.numOfAvailableStudents = numOfAvailableStudents;
        sinhViens = new ArrayList<>();
    }

    public ArrayList<SinhVien> getSinhViens() {
        return sinhViens;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        String s = String.format("DANH SACH THUC TAP TAI %s:\n", name);
        Collections.sort(sinhViens);
        while (numOfAvailableStudents < sinhViens.size()) sinhViens.remove(sinhViens.size() - 1);
        for (SinhVien x : sinhViens) s += (x.toString() + "\n");
        return s;
    }
}

public class J07038 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("DN.in"));
        Scanner sc3 = new Scanner(new File("THUCTAP.in"));
        int n = sc1.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            String grade = sc1.next();
            String email = sc1.next();
            a.add(new SinhVien(id, name, grade, email));
        }
        int m = sc2.nextInt();
        ArrayList<DoanhNghiep> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String id = sc2.next();
            sc2.nextLine();
            String name = sc2.nextLine();
            int numOfAvailableStudents = sc2.nextInt();
            b.add(new DoanhNghiep(id, name, numOfAvailableStudents));
        }
        int p = sc3.nextInt();
        while (p-- > 0) {
            String studentId = sc3.next();
            String doanhNghiepId = sc3.next();
            for (DoanhNghiep x : b)
                if (x.getId().equals(doanhNghiepId)) {
                    for (SinhVien y : a)
                        if (y.getId().equals(studentId)) x.getSinhViens().add(y);
                }
        }
        int q = sc3.nextInt();
        while (q-- > 0) {
            String id = sc3.next();
            for (DoanhNghiep x : b)
                if (x.getId().equals(id)) {
                    System.out.print(x);
                    break;
                }
        }
        sc1.close();
        sc2.close();
        sc3.close();
    }
}