import java.util.*;

class ThiSinh implements Comparable<ThiSinh> {
    public static int ID = 0;
    private int id;
    private String name;
    private String dob;
    private double mark1;
    private double mark2;
    private double mark3;

    public ThiSinh(String name, String dob, double mark1, double mark2, double mark3) {
        this.id = ++ID;
        this.name = name;
        this.dob = dob;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTotalMark() {
        return this.mark1 + this.mark2 + this.mark3;
    }

    @Override
    public int compareTo(ThiSinh o) {
        if (this.getTotalMark() != o.getTotalMark()) return -Double.compare(this.getTotalMark(), o.getTotalMark());
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %.1f", this.id, this.name, this.dob, this.getTotalMark());
    }
}

public class J05009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<ThiSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new ThiSinh(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a);
        double max = a.get(0).getTotalMark();
        for (ThiSinh x : a)
            if (max == x.getTotalMark()) System.out.println(x);
            else break;
        sc.close();
    }
}