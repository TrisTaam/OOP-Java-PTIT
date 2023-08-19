import java.util.*;

class ThiSinh {
    private String name;
    private String dob;
    private double[] mark = new double[3];

    public ThiSinh(String name, String dob, double[] mark) {
        this.name = name;
        this.dob = dob;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double[] getMark() {
        return mark;
    }

    public void setMark(double[] mark) {
        this.mark = mark;
    }

    public double getSum() {
        double s = 0;
        for (double x : this.mark) s += x;
        return s;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f", this.name, this.dob, this.getSum());
    }
}

public class J04005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        String name = sc.nextLine();
        String dob = sc.next();
        double[] mark = new double[3];
        for (int i = 0; i < 3; ++i) mark[i] = sc.nextDouble();
        ThiSinh a = new ThiSinh(name, dob, mark);
        System.out.println(a);
        sc.close();
    }
}