import java.util.ArrayList;
import java.util.Scanner;

class KhachHang {
    private static int ID = 0;
    private static final String KEY = "KH";
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;

    public KhachHang(String name, String gender, String dob, String address) {
        id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

class MatHang {
    private static int ID = 0;
    private static final String KEY = "MH";
    private String id;
    private String name;
    private String unit;
    private int buyPrice;
    private int sellPrice;

    public MatHang(String name, String unit, int buyPrice, int sellPrice) {
        id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.unit = unit;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}

class HoaDon {
    private static int ID = 0;
    private static final String KEY = "HD";
    private String id;
    private KhachHang khachHang;
    private MatHang matHang;
    private int amount;

    public HoaDon(int amount) {
        id = String.format("%s%03d", KEY, ++ID);
        this.amount = amount;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d %d %d %d", id, khachHang.getName(), khachHang.getAddress(), matHang.getName(), matHang.getUnit(), matHang.getBuyPrice(), matHang.getSellPrice(), amount, amount * matHang.getSellPrice());
    }
}

public class J06005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            a.add(new KhachHang(name, gender, dob, address));
        }
        int m = sc.nextInt();
        ArrayList<MatHang> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            sc.nextLine();
            b.add(new MatHang(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        int k = sc.nextInt();
        ArrayList<HoaDon> c = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            String khachHangId = sc.next();
            String matHangId = sc.next();
            int amount = sc.nextInt();
            HoaDon d = new HoaDon(amount);
            for (KhachHang x : a)
                if (x.getId().equals(khachHangId)) {
                    d.setKhachHang(x);
                    break;
                }
            for (MatHang x : b)
                if (x.getId().equals(matHangId)) {
                    d.setMatHang(x);
                    break;
                }
            c.add(d);
        }
        for (HoaDon x : c) System.out.println(x);
        sc.close();
    }
}
