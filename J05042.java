import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String name;
    private int numOfAC;
    private int numOfSubmit;

    public SinhVien(String name, int numOfAC, int numOfSubmit) {
        this.name = name;
        this.numOfAC = numOfAC;
        this.numOfSubmit = numOfSubmit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfAC() {
        return numOfAC;
    }

    public void setNumOfAC(int numOfAC) {
        this.numOfAC = numOfAC;
    }

    public int getNumOfSubmit() {
        return numOfSubmit;
    }

    public void setNumOfSubmit(int numOfSubmit) {
        this.numOfSubmit = numOfSubmit;
    }

    @Override
    public int compareTo(SinhVien o) {
        if (this.numOfAC != o.numOfAC) return -Integer.compare(this.numOfAC, o.numOfAC);
        if (this.numOfSubmit != o.numOfSubmit) return Integer.compare(this.numOfSubmit, o.numOfSubmit);
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numOfAC, this.numOfSubmit);
    }
}

public class J05042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new SinhVien(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}
