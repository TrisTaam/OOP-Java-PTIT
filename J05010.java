import java.io.*;
import java.util.*;

class MatHang implements Comparable<MatHang> {
    public static int ID = 0;
    private int id;
    private String name;
    private String group;
    private double buyPrice;
    private double sellPrice;

    public MatHang(String name, String group, double buyPrice, double sellPrice) {
        this.id = ++ID;
        this.name = name;
        this.group = group;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getProfit() {
        return this.sellPrice - this.buyPrice;
    }

    @Override
    public int compareTo(MatHang o) {
        return -Double.compare(this.getProfit(), o.getProfit());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.2f", this.id, this.name, this.group, this.getProfit());
    }
}

public class J05010 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<MatHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new MatHang(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a);
        for (MatHang x : a) System.out.println(x);
    }
}
