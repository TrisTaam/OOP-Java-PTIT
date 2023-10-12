import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Bill implements Comparable<Bill> {
    private String id;
    private String name;
    private int amount;
    private long unitPrice;
    private long discount;
    private long finalPrice;

    public Bill(String id, String name, int amount, long unitPrice, long discount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.finalPrice = unitPrice * amount - discount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.amount, this.unitPrice, this.discount, this.finalPrice);
    }

    @Override
    public int compareTo(Bill o) {
        return -Long.compare(this.finalPrice, o.finalPrice);
    }
}

public class J05012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Bill> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int amount = sc.nextInt();
            long unitPrice = sc.nextLong();
            long discount = sc.nextLong();
            a.add(new Bill(id, name, amount, unitPrice, discount));
        }
        Collections.sort(a);
        for (Bill x : a) System.out.println(x);
        sc.close();
    }
}