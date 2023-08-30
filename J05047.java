import java.util.*;

class Goods implements Comparable<Goods> {
    public static HashMap<String, Integer> map = new HashMap<>();
    private String id;
    private String name;
    private int amount;
    private int unitPrice;
    private int discount;
    private int finalPrice;

    public Goods(String name, int amount, int unitPrice) {
        String[] x = name.toUpperCase().split("\\s+");
        String y = String.valueOf(x[0].charAt(0)) + x[1].charAt(0);
        if (map.containsKey(y)) map.put(y, map.get(y) + 1);
        else map.put(y, 1);
        this.id = String.format("%s%02d", y, map.get(y));
        this.name = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
        float tmp;
        if (amount > 10) tmp = 0.05f;
        else if (amount >= 8) tmp = 0.02f;
        else if (amount >= 5) tmp = 0.01f;
        else tmp = 0f;
        this.discount = (int) (unitPrice * amount * tmp);
        this.finalPrice = this.unitPrice * amount - this.discount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", this.id, this.name, this.discount, this.finalPrice);
    }

    @Override
    public int compareTo(Goods o){
        return -Integer.compare(this.discount, o.discount);
    }
}

public class J05047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new Goods(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (Goods x : a) System.out.println(x);
        sc.close();
    }
}
