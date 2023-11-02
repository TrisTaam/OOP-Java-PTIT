import java.util.*;

class DonHang {
    private String id;
    private int unitPrice;
    private int amount;
    private double finalUnitPrice;

    public DonHang(String id, int unitPrice, int amount) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.amount = amount;
        double tax = 0;
        double ship = 0;
        switch (id.charAt(0)) {
            case 'T':
                tax = 0.29;
                ship = 0.04;
                break;
            case 'C':
                tax = 0.1;
                ship = 0.03;
                break;
            case 'D':
                tax = 0.08;
                ship = 0.025;
                break;
            case 'M':
                tax = 0.02;
                ship = 0.005;
                break;
            default:
                tax = 0;
                ship = 0;
                break;
        }
        double discount = 0;
        if (id.charAt(id.length() - 1) == 'C') discount = 0.05;
        double price = (double) unitPrice * amount;
        double taxPrice = price * tax * (1 - discount);
        double shipPrice = price * ship;
        this.finalUnitPrice = (price + taxPrice + shipPrice) * (1 + 0.2) / amount;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", this.id, this.finalUnitPrice);
    }
}

public class J05073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DonHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new DonHang(sc.next(), sc.nextInt(), sc.nextInt()));
        for (DonHang x : a) System.out.println(x);
        sc.close();
    }
}