import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class SanPham implements Comparable<SanPham> {
    private String id;
    private String name;
    private int price;
    private int guarantee;

    public SanPham(String id, String name, int price, int guarantee) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.guarantee = guarantee;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public int compareTo(SanPham o) {
        if (this.price != o.price) return -Integer.compare(this.price, o.price);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", this.id, this.name, this.price, this.guarantee);
    }
}

public class J07048 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = sc.nextInt();
        ArrayList<SanPham> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int price = sc.nextInt();
            int guarantee = sc.nextInt();
            a.add(new SanPham(id, name, price, guarantee));
        }
        Collections.sort(a);
        for (SanPham x : a) System.out.println(x);
    }
}
