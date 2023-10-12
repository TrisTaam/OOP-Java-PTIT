import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class ThiSinh implements Comparable<ThiSinh> {
    private static int ID = 0;
    private static final String KEY = "TS";
    private String id;
    private String name;
    private double theory;
    private double practice;
    private double averageMark;
    private String status;

    public ThiSinh(String name, double theory, double practice) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.theory = standardize(theory);
        this.practice = standardize(practice);
        this.averageMark = (this.theory + this.practice) / 2;
        if (this.averageMark > 9.5) this.status = "XUAT SAC";
        else if (this.averageMark >= 8) this.status = "DAT";
        else if (this.averageMark >= 5) this.status = "CAN NHAC";
        else this.status = "TRUOT";
    }

    public static double standardize(double n) {
        if (n > 10) return n / 10;
        return n;
    }

    @Override
    public int compareTo(ThiSinh o) {
        return -Double.compare(this.averageMark, o.averageMark);
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", this.id, this.name, this.averageMark, this.status);
    }
}

public class J05013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<ThiSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new ThiSinh(sc.nextLine(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a);
        for (ThiSinh x : a) System.out.println(x);
        sc.close();
    }
}