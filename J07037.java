import java.io.*;
import java.util.*;

class DoanhNghiep implements Comparable<DoanhNghiep> {
    private String id;
    private String name;
    private int numOfSV;

    public DoanhNghiep(String id, String name, int numOfSV) {
        this.id = id;
        this.name = name;
        this.numOfSV = numOfSV;
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

    public int getNumOfSV() {
        return numOfSV;
    }

    public void setNumOfSV(int numOfSV) {
        this.numOfSV = numOfSV;
    }

    @Override
    public int compareTo(DoanhNghiep o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.numOfSV);
    }
}

public class J07037 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DN.in"));
        int n = sc.nextInt();
        ArrayList<DoanhNghiep> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int numOfSV = sc.nextInt();
            a.add(new DoanhNghiep(id, name, numOfSV));
        }
        Collections.sort(a);
        for (DoanhNghiep x : a) System.out.println(x);
    }
}
