import java.io.*;
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    public static int ID = 0;
    public static final String KEY = "SV";
    private String id;
    private String name;
    private int mark1;
    private int mark2;
    private int mark3;
    private int rank;

    public SinhVien(String name, int mark1, int mark2, int mark3) {
        this.id = String.format("%s%02d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
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

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public float getAverage() {
        return (float) (mark1 * 3 + mark2 * 3 + mark3 * 2) / 8;
    }

    @Override
    public int compareTo(SinhVien o) {
        if (this.getAverage() != o.getAverage()) return -Float.compare(this.getAverage(), o.getAverage());
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %d", this.id, this.name, this.getAverage(), this.rank);
    }
}

public class J07054 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new SinhVien(sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        float currentVal = 0;
        int currentRank = 0;
        int tmp = 0;
        for (int i = 0; i < n; ++i) {
            if (currentVal == a.get(i).getAverage()) {
                a.get(i).setRank(currentRank);
                tmp += 1;
            } else {
                currentRank += (tmp + 1);
                tmp=0;
                a.get(i).setRank(currentRank);
            }
            currentVal = a.get(i).getAverage();
        }
        for (SinhVien x : a) System.out.println(x);
    }
}
