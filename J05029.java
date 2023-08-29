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
        if (this.numOfSV != o.numOfSV) return -Integer.compare(this.numOfSV, o.numOfSV);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.name, this.numOfSV);
    }
}

public class J05029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        int q = sc.nextInt();
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.printf("DANH SACH DOANH NGHIEP NHAN TU %d DEN %d SINH VIEN:\n", l, r);
            for (DoanhNghiep x : a)
                if (l <= x.getNumOfSV() && x.getNumOfSV() <= r) System.out.println(x);
        }
        sc.close();
    }
}
