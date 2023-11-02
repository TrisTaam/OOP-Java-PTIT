import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;

    public MonHoc(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class GiangVien {
    private String id;
    private String name;
    private double numOfHours;

    public GiangVien(String id, String name) {
        this.id = id;
        this.name = name;
        numOfHours = 0;
    }

    public String getId() {
        return id;
    }

    public void addHour(double hour) {
        numOfHours += hour;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", name, numOfHours);
    }
}

public class J06007 {
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
                    x.addHour(hour);
                    break;
                }
        }
        for (GiangVien x : b) System.out.println(x);
        sc.close();
    }
}
