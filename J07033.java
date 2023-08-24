import java.io.*;
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String grade;
    private String email;

    public SinhVien(String id, String name, String grade, String email) {
        this.id = id;
        String tmp = "";
        this.name = "";
        for (int i = 0; i < name.length(); ++i)
            if (name.charAt(i) == ' ') {
                if (!tmp.isEmpty()) {
                    this.name += (tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase() + " ");
                    tmp = "";
                }
            } else {
                tmp += name.charAt(i);
            }
        this.name += (tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase());
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

    @Override
    public int compareTo(SinhVien o) {
        return this.id.compareTo(o.id);
    }
}

public class J07033 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
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
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
    }
}
