import java.util.*;

class NhienLieu implements Comparable<NhienLieu> {
    private String id;
    private String name;
    private int unitPrice;
    private long tax;
    private long finalPrice;

    public NhienLieu(String id, int amount) {
        this.id = id;
        double tmp = 0;
        switch (id.charAt(0)) {
            case 'X':
                this.unitPrice = 128000;
                tmp = 0.03;
                break;
            case 'D':
                this.unitPrice = 11200;
                tmp = 0.035;
                break;
            case 'N':
                this.unitPrice = 9700;
                tmp = 0.02;
                break;
            default:
                break;
        }
        switch (id.substring(id.length() - 2)) {
            case "BP":
                this.name = "British Petro";
                break;
            case "ES":
                this.name = "Esso";
                break;
            case "SH":
                this.name = "Shell";
                break;
            case "CA":
                this.name = "Castrol";
                break;
            case "MO":
                this.name = "Mobil";
                break;
            case "TN":
                this.name = "Trong Nuoc";
                tmp = 0;
                break;
            default:
                break;
        }
        long price = (long) this.unitPrice * amount;
        this.tax = (long) (price * tmp);
        this.finalPrice = price + tax;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", this.id, this.name, this.unitPrice, this.tax, this.finalPrice);
    }

    @Override
    public int compareTo(NhienLieu o){
        return -Long.compare(this.finalPrice, o.finalPrice);
    }
}

public class J05068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhienLieu> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) a.add(new NhienLieu(sc.next(), sc.nextInt()));
        Collections.sort(a);
        for (NhienLieu x : a) System.out.println(x);
        sc.close();
    }
}