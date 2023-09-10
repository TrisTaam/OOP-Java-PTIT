import java.util.*;

class KhachHang {
    public static int ID = 0;
    public static final String KEY = "KH";
    private String id;
    private String type;
    private int oldIndex;
    private int newIndex;
    private int coefficient;
    private int price;
    private int allowance;
    private int finalPrice;

    public KhachHang(String type, int oldIndex, int newIndex) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.type = type;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        switch (type) {
            case "KD":
                this.coefficient = 3;
                break;
            case "NN":
                this.coefficient = 5;
                break;
            case "TT":
                this.coefficient = 4;
                break;
            case "CN":
                this.coefficient = 2;
                break;
            default:
                break;
        }
        this.price = (newIndex - oldIndex) * this.coefficient * 550;
        if (newIndex - oldIndex > 100) this.allowance = this.price;
        else if (newIndex - oldIndex >= 50) this.allowance = Math.round(this.price * 0.35f);
        else this.allowance = 0;
        this.finalPrice = this.allowance + this.price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d", this.id, this.coefficient, this.price, this.allowance, this.finalPrice);
    }
}

public class J05050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new KhachHang(sc.next(), sc.nextInt(), sc.nextInt()));
        for (KhachHang x : a) System.out.println(x);
        sc.close();
    }
}
