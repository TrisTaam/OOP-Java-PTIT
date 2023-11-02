import java.io.File;
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

public class J07028 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("GIANGVIEN.in"));
        Scanner sc3 = new Scanner(new File("GIOCHUAN.in")).useLocale(Locale.getDefault());
        int n = sc1.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new MonHoc(sc1.next(), sc1.nextLine().trim()));
        int m = sc2.nextInt();
        ArrayList<GiangVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new GiangVien(sc2.next(), sc2.nextLine().trim()));
        int k = sc3.nextInt();
        while (k-- > 0) {
            String giaoVienId = sc3.next();
            String monHocId = sc3.next();
            double hour = sc3.nextDouble();
            for (GiangVien x : b)
                if (x.getId().equals(giaoVienId)) {
                    x.addHour(hour);
                    break;
                }
        }
        for (GiangVien x : b) System.out.println(x);
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
