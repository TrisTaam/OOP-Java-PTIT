import java.util.ArrayList;
import java.util.Scanner;

class SanPham {
    private String id;
    private String name;
    private int type1Price;
    private int type2Price;

    public SanPham(String id, String name, int type1Price, int type2Price) {
        this.id = id;
        this.name = name;
        this.type1Price = type1Price;
        this.type2Price = type2Price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType1Price() {
        return type1Price;
    }

    public int getType2Price() {
        return type2Price;
    }
}

class HoaDon {
    private static int ID = 0;
    private String id;
    private int amount;
    private SanPham sanPham;
    private int discount;
    private int finalPrice;

    public HoaDon(String id, int amount) {
        this.id = String.format("%s-%03d", id, ++ID);
        this.amount = amount;
        discount = 0;
    }

    public String getId() {
        return id;
    }

    public void setSanPham(SanPham sanPham, char type) {
        this.sanPham = sanPham;
        int unitPrice = 0;
        if (type == '1') unitPrice = sanPham.getType1Price();
        else unitPrice = sanPham.getType2Price();
        int price = unitPrice * amount;
        if (amount >= 150) discount = (int) (price * 0.5);
        else if (amount >= 100) discount = (int) (price * 0.3);
        else if (amount >= 50) discount = (int) (price * 0.15);
        finalPrice = price - discount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", id, sanPham.getName(), discount, finalPrice);
    }
}

public class J06001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SanPham> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int type1Price = sc.nextInt();
            int type2Price = sc.nextInt();
            a.add(new SanPham(id, name, type1Price, type2Price));
        }
        int m = sc.nextInt();
        ArrayList<HoaDon> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            HoaDon c = new HoaDon(sc.next(), sc.nextInt());
            for (SanPham x : a)
                if (x.getId().equals(c.getId().substring(0, 2))) {
                    c.setSanPham(x, c.getId().charAt(2));
                    break;
                }
            b.add(c);
        }
        for (HoaDon x : b) System.out.println(x);
        sc.close();
    }
}
