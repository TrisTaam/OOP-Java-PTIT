import java.util.*;

class DonHang {
    private String name;
    private String id;
    private int unitPrice;
    private int amount;
    private String orderIndex;
    private int discount;
    private int finalPrice;

    public DonHang(String name, String id, int unitPrice, int amount) {
        this.name = name;
        this.id = id;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.orderIndex = id.substring(1, 4);
        if (id.charAt(id.length() - 1) == '1') this.discount = (int) (unitPrice * amount * 0.5f);
        else if (id.charAt(id.length() - 1) == '2') this.discount = (int) (unitPrice * amount * 0.3f);
        this.finalPrice = unitPrice * amount - this.discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(String orderIndex) {
        this.orderIndex = orderIndex;
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
        return String.format("%s %s %s %d %d", this.name, this.id, this.orderIndex, this.discount, this.finalPrice);
    }
}

public class J05052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DonHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new DonHang(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        for (DonHang x : a) System.out.println(x);
        sc.close();
    }
}
