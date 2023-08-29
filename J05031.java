import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String grade;
    private double mark1;
    private double mark2;
    private double mark3;

    public SinhVien(String id, String name, String grade, double mark1, double mark2, double mark3) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
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

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %.1f %.1f", this.id, this.name, this.grade, this.mark1, this.mark2, this.mark3);
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.name.compareTo(o.name);
    }
}

public class J05031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            double mark1 = sc.nextDouble();
            double mark2 = sc.nextDouble();
            double mark3 = sc.nextDouble();
            a.add(new SinhVien(id, name, grade, mark1, mark2, mark3));
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); ++i) System.out.printf("%d %s\n", i + 1, a.get(i));
        sc.close();
    }
}
