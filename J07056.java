import java.io.*;
import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    public static int ID = 0;
    public static final String KEY = "KH";
    private String id;
    private String name;
    private int quota;
    private int usage;
    private int in;
    private int out;
    private int VAT;

    public KhachHang(String name, String type, int start, int end) {
        this.id = String.format("%s%02d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        switch (type) {
            case "A":
                this.quota = 100;
                break;
            case "B":
                this.quota = 500;
                break;
            case "C":
                this.quota = 200;
                break;
        }
        this.usage = end - start;
        this.in = Math.min(this.usage, this.quota) * 450;
        this.out = Math.max(this.usage - this.quota, 0) * 1000;
        this.VAT = (int) (this.out * 0.05f);
    }

    public int getSum() {
        return this.in + this.out + this.VAT;
    }

    @Override
    public int compareTo(KhachHang o) {
        return -Integer.compare(this.getSum(), o.getSum());
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.in, this.out, this.VAT, this.getSum());
    }
}

public class J07056 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new KhachHang(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
    }
}
