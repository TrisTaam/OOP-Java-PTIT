import java.util.*;

class SinhVien {
    public static final String KEY = "B20DCCN";
    public static int ID = 0;
    private String id;
    private String name;
    private String grade;
    private String dob;
    private double gpa;

    public SinhVien(String name, String grade, String dob, double gpa) {
        this.id = String.format("%s%03d", KEY, ++ID);
        String[] x = name.trim().toLowerCase().split("\\s+");
        this.name = x[0].substring(0, 1).toUpperCase() + x[0].substring(1);
        for (int i = 1; i < x.length; ++i) this.name += (" " + x[i].substring(0, 1).toUpperCase() + x[i].substring(1));
        this.grade = grade;
        String[] tmp = dob.split("/");
        this.dob = String.format("%02d/%02d/%s", Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), tmp[2]);
        this.gpa = gpa;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", this.id, this.name, this.grade, this.dob, this.gpa);
    }
}

public class J05004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int t=sc.nextInt();
        while(t-->0) {
            sc.nextLine();
            SinhVien a = new SinhVien(sc.nextLine(), sc.next(), sc.next(), sc.nextDouble());
            System.out.println(a);
        }
        sc.close();
    }
}