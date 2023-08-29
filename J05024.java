import java.io.*;
import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private String email;

    public SinhVien(String id, String name, String grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.grade, this.email);
    }
}

public class J05024 {
    public static String res(String s) {
        if (s.equals("KE TOAN")) return "DCKT";
        if (s.equals("CONG NGHE THONG TIN")) return "DCCN";
        if (s.equals("AN TOAN THONG TIN")) return "DCAT";
        if (s.equals("VIEN THONG")) return "DCVT";
        return "DCDT";
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            a.add(new SinhVien(id, name, grade, email));
        }
        int q = sc.nextInt();
        sc.nextLine();
        while (q-- > 0) {
            String major = sc.nextLine().toUpperCase();
            System.out.printf("DANH SACH SINH VIEN NGANH %s:\n", major);
            major = res(major);
            for (SinhVien x : a)
                if (x.getId().substring(3, 7).equals(major)) {
                    if (major.equals("DCCN") || major.equals("DCAT")) {
                        if (x.getGrade().charAt(0) != 'E') System.out.println(x);
                    } else System.out.println(x);
                }
        }
        sc.close();
    }
}
