import java.io.File;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class SinhVien {
    private static int ID = 0;
    private static final String KEY = "B20DCCN";
    private String id;
    private String name;
    private String grade;
    private String dob;
    private float gpa;

    public SinhVien(String name, String grade, String dob, float gpa) {
        this.id = String.format("%s%03d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.grade = grade;
        String[] tmpDob = dob.split("/");
        this.dob = String.format("%02d/%02d/%d", Integer.parseInt(tmpDob[0]), Integer.parseInt(tmpDob[1]), Integer.parseInt(tmpDob[2]));
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", id, name, grade, dob, gpa);
    }
}

public class J07018 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SINHVIEN.in")).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new SinhVien(sc.nextLine(), sc.next(), sc.next(), sc.nextFloat()));
        }
        for (SinhVien x : a) System.out.println(x);
    }
}
