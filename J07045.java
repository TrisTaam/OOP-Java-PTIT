import java.io.*;
import java.util.*;

class LoaiPhong implements Comparable<LoaiPhong> {
    private String symbol;
    private String name;
    private int price;
    private double serviceFee;

    public LoaiPhong(String data) {
        String[] tmp = data.trim().split("\\s+");
        this.symbol = tmp[0];
        this.name = tmp[1];
        this.price = Integer.parseInt(tmp[2]);
        this.serviceFee = Double.parseDouble(tmp[3]);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    @Override
    public int compareTo(LoaiPhong o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %.2f", this.symbol, this.name, this.price, this.serviceFee);
    }
}

public class J07045 {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while (n-- > 0) {
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for (LoaiPhong tmp : ds) {
            System.out.println(tmp);
        }
    }
}
