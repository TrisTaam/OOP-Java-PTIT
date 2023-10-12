import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private String id;
    private String name;
    private int startIndex;
    private int endIndex;
    private int finalPrice;

    public KhachHang(String name, int startIndex, int endIndex) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        int amount = endIndex - startIndex;
        double allowance = 0;
        double price = 0;
        if (amount > 100) {
            price = 50 * 100 + 50 * 150 + (amount - 100) * 200;
            allowance = 0.05;
        } else if (amount > 50) {
            price = 50 * 100 + (amount - 50) * 150;
            allowance = 0.03;
        } else {
            price = amount * 100;
            allowance = 0.02;
        }
        this.finalPrice = (int) Math.round(price * (1 + allowance));
    }

    @Override
    public int compareTo(KhachHang o) {
        return -Integer.compare(this.finalPrice, o.finalPrice);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.finalPrice);
    }
}

public class J05017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new KhachHang(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
        sc.close();
    }
}