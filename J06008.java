import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class Pair<X, Y> {
    private X first;
    private Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }
}

class MonHoc {
    private String id;
    private String name;

    public MonHoc(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class GiangVien {
    private String id;
    private String name;
    private double numOfHours;
    private ArrayList<Pair<MonHoc, Double>> monHocList;

    public GiangVien(String id, String name) {
        this.id = id;
        this.name = name;
        numOfHours = 0;
        monHocList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public ArrayList<Pair<MonHoc, Double>> getMonHocList() {
        return monHocList;
    }

    public void addHour(double hour) {
        numOfHours += hour;
    }

    @Override
    public String toString() {
        String s = String.format("Giang vien: %s\n", name);
        for (Pair<MonHoc, Double> x : monHocList)
            s += String.format("%s %s\n", x.getFirst().getName(), x.getSecond());
        s += String.format("Tong: %.2f", numOfHours);
        return s;
    }
}

public class J06008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new MonHoc(sc.next(), sc.nextLine().trim()));
        int m = sc.nextInt();
        ArrayList<GiangVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new GiangVien(sc.next(), sc.nextLine().trim()));
        int k = sc.nextInt();
        while (k-- > 0) {
            String giaoVienId = sc.next();
            String monHocId = sc.next();
            double hour = sc.nextDouble();
            for (GiangVien x : b)
                if (x.getId().equals(giaoVienId)) {
                    for (MonHoc y : a)
                        if (y.getId().equals(monHocId)) {
                            x.getMonHocList().add(new Pair<>(y, hour));
                            x.addHour(hour);
                            break;
                        }
                    break;
                }
        }
        String id = sc.next();
        for (GiangVien x : b)
            if (x.getId().equals(id)) {
                System.out.println(x);
                break;
            }
        sc.close();
    }
}
