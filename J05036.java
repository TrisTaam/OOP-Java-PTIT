import java.util.*;

class Goods {
    public static int ID = 0;
    public static final String KEY = "MH";
    private String id;
    private String name;
    private String unit;
    private int unitPrice;
    private int amount;
    private int shipPrice;
    private int price;
    private int finalPrice;

    public Goods(String name, String unit, int unitPrice, int amount) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.shipPrice = Math.round((unitPrice * amount) * 0.05f);
        this.price = unitPrice * amount + this.shipPrice;
        this.finalPrice = Math.round(this.price * 1.02f);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(int shipPrice) {
        this.shipPrice = shipPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d %d", this.id, this.name, this.unit, this.shipPrice, this.price, this.finalPrice);
    }
}

public class J05036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<Goods>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new Goods(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        for (Goods x : a) System.out.println(x);
        sc.close();
    }
}
