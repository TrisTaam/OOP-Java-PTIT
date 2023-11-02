import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Phong {
    private String symbol;
    private String type;
    private int unitPrice;
    private double service;

    public Phong(String symbol, String type, int unitPrice, double service) {
        this.symbol = symbol;
        this.type = type;
        this.unitPrice = unitPrice;
        this.service = service;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public double getService() {
        return service;
    }
}

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String phongId;
    private int numOfDays;
    private double discount;
    private Phong phong;

    public KhachHang(String name, String phongId, String start, String end) throws ParseException {
        id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.phongId = phongId;
        Date startDate = formatter.parse(start);
        Date endDate = formatter.parse(end);
        numOfDays = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
        if (numOfDays > 30) discount = 0.06;
        else if (numOfDays >= 20) discount = 0.04;
        else if (numOfDays >= 10) discount = 0.02;
        else discount = 0;
    }

    public String getPhongId() {
        return phongId;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public double getPrice() {
        double price = numOfDays * phong.getUnitPrice();
        if (numOfDays == 0) price = phong.getUnitPrice();
        return price * (1 - discount) * (1 + phong.getService());
    }

    @Override
    public int compareTo(KhachHang o) {
        return -Integer.compare(numOfDays, o.numOfDays);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %.2f", id, name, phongId, numOfDays, getPrice());
    }
}

public class J07047 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DATA.in")).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Phong> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new Phong(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble()));
        int m = sc.nextInt();
        ArrayList<KhachHang> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            sc.nextLine();
            KhachHang c = new KhachHang(sc.nextLine(), sc.next(), sc.next(), sc.next());
            for (Phong x : a)
                if (x.getSymbol().equals(c.getPhongId().substring(2, 3))) {
                    c.setPhong(x);
                    break;
                }
            b.add(c);
        }
        Collections.sort(b);
        for (KhachHang x : b) System.out.println(x);
        sc.close();
    }
}
