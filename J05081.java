import java.util.*;

class Goods implements Comparable<Goods> {
    public static int ID = 0;
    public final String KEY = "MH";
    private String id;
    private String name;
    private String unit;
    private int buyPrice;
    private int sellPrice;

    public Goods(String name, String unit, int buyPrice, int sellPrice) {
        this.id = String.format("%s%03d", KEY, ++ID);
        this.name = name;
        this.unit = unit;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
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

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getProfit() {
        return this.sellPrice - this.buyPrice;
    }

    @Override
    public int compareTo(Goods o) {
        if (this.getProfit() != o.getProfit()) return -Integer.compare(this.getProfit(), o.getProfit());
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d %d", this.id, this.name, this.unit, this.buyPrice, this.sellPrice, this.getProfit());
    }
}

public class J05081 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new Goods(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (Goods x : a) System.out.println(x);
        sc.close();
    }
}