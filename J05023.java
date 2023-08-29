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

public class J05023 {
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
        while (q-- > 0) {
            String course = sc.next();
            System.out.printf("DANH SACH SINH VIEN KHOA %s:\n", course);
            for (SinhVien x : a)
                if (x.getGrade().substring(1,3).equals(course.substring(2))) System.out.println(x);
        }
        sc.close();
    }
}
