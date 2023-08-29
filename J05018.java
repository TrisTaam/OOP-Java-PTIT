import java.util.*;

class HocSinh implements Comparable<HocSinh> {
    public static int ID = 0;
    public static final String KEY = "HS";
    private String id;
    private String name;
    private double[] mark;
    private String rank;

    public HocSinh(String name, double[] mark) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.mark = mark;
        double finalMark = this.getAverage();
        if (finalMark >= 9) this.rank = "XUAT SAC";
        else if (finalMark >= 8) this.rank = "GIOI";
        else if (finalMark >= 7) this.rank = "KHA";
        else if (finalMark >= 5) this.rank = "TB";
        else this.rank = "YEU";
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

    public double[] getMark() {
        return mark;
    }

    public void setMark(double[] mark) {
        this.mark = mark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getAverage() {
        double s = 0;
        for (int i = 0; i < 10; ++i)
            if (i <= 1) s += 2 * this.mark[i];
            else s += this.mark[i];
        return s / 12;
    }

    @Override
    public int compareTo(HocSinh o) {
        if (this.getAverage() != o.getAverage()) return -Double.compare(this.getAverage(), o.getAverage());
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", this.id, this.name, Math.round(this.getAverage() * 10.f) / 10.f, this.rank);
    }
}

public class J05018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<HocSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            double[] mark = new double[10];
            for (int j = 0; j < 10; ++j) mark[j] = sc.nextDouble();
            a.add(new HocSinh(name, mark));
        }
        Collections.sort(a);
        for (HocSinh x : a) System.out.println(x);
        sc.close();
    }
}