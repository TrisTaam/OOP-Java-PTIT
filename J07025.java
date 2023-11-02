import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String gender;
    private Date dob;
    private String address;

    public KhachHang(String name, String gender, String dob, String address) throws ParseException {
        this.id = String.format("%s%03d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.gender = gender;
        String[] tmpDob = dob.split("/");
        dob = String.format("%02d/%02d/%d", Integer.parseInt(tmpDob[0]), Integer.parseInt(tmpDob[1]), Integer.parseInt(tmpDob[2]));
        this.dob = formatter.parse(dob);
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", id, name, gender, address, formatter.format(dob));
    }

    @Override
    public int compareTo(KhachHang o) {
        return Long.compare(this.dob.getTime(), o.dob.getTime());
    }
}

public class J07025 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            a.add(new KhachHang(name, gender, dob, address));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
    }
}
