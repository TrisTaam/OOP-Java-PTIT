import java.util.*;

class Goods implements Comparable<Goods> {
    private String id;
    private int importAmount;
    private int exportAmount;
    private int unitPrice;
    private int price;
    private int tax;

    public Goods(String id, int importAmount) {
        this.id = id;
        this.importAmount = importAmount;
        if (id.charAt(0) == 'A') this.exportAmount = Math.round(importAmount * 0.6f);
        else if (id.charAt(0) == 'B') this.exportAmount = Math.round(importAmount * 0.7f);
        if (id.charAt(id.length() - 1) == 'Y') this.unitPrice = 110000;
        else if (id.charAt(id.length() - 1) == 'N') this.unitPrice = 135000;
        this.price = this.exportAmount * this.unitPrice;
        float tmp = 0f;
        if (id.charAt(0) == 'A') {
            if (id.charAt(id.length() - 1) == 'Y') tmp = 0.08f;
            else if (id.charAt(id.length() - 1) == 'N') tmp = 0.11f;
        } else if (id.charAt(0) == 'B') {
            if (id.charAt(id.length() - 1) == 'Y') tmp = 0.17f;
            else if (id.charAt(id.length() - 1) == 'N') tmp = 0.22f;
        }
        this.tax = Math.round(this.price * tmp / 10) * 10;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImportAmount() {
        return importAmount;
    }

    public void setImportAmount(int importAmount) {
        this.importAmount = importAmount;
    }

    public int getExportAmount() {
        return exportAmount;
    }

    public void setExportAmount(int exportAmount) {
        this.exportAmount = exportAmount;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d %d", this.id, this.importAmount, this.exportAmount, this.unitPrice, this.price, this.tax);
    }

    @Override
    public int compareTo(Goods o) {
        return -Integer.compare(this.tax,o.tax);
    }
}

public class J05049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Goods> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new Goods(sc.next(), sc.nextInt()));
        Collections.sort(a);
        String s=sc.next();
        for (Goods x : a)
            if (x.getId().contains(s)) System.out.println(x);
        sc.close();
    }
}
