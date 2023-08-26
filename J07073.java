import java.io.*;
import java.util.*;

class MonHoc implements Comparable<MonHoc> {
    private String id;
    private String name;
    private byte credit;
    private String theory;
    private String practice;

    public MonHoc(String id, String name, byte credit, String theory, String practice) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.theory = theory;
        this.practice = practice;
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

    public byte getCredit() {
        return credit;
    }

    public void setCredit(byte credit) {
        this.credit = credit;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    @Override
    public int compareTo(MonHoc o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s %s", this.id, this.name, this.credit, this.theory, this.practice);
    }
}

public class J07073 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        ArrayList<MonHoc> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            byte credit = sc.nextByte();
            sc.nextLine();
            String theory = sc.nextLine();
            String practice = sc.nextLine();
            a.add(new MonHoc(id, name, credit, theory, practice));
        }
        Collections.sort(a);
        for (MonHoc x : a)
            if (!x.getPractice().equals("Truc tiep")) System.out.println(x);
    }
}
