import java.util.*;

class NhanVien implements Comparable<NhanVien> {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private String position;
    private int baseSalary;
    private int numOfWork;
    private int allowance;
    private int mainSalary;
    private int advance;
    private int remain;

    public NhanVien(String name, String position, int baseSalary, int numOfWork) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.position = position;
        this.baseSalary = baseSalary;
        this.numOfWork = numOfWork;
        this.mainSalary = baseSalary * numOfWork;
        switch (position) {
            case "GD":
                this.allowance = 500;
                break;
            case "PGD":
                this.allowance = 400;
                break;
            case "TP":
                this.allowance = 300;
                break;
            case "KT":
                this.allowance = 250;
                break;
            default:
                this.allowance = 100;
                break;
        }
        this.advance = Math.min(Math.round((this.allowance + this.mainSalary) * 2 / 3.f / 1000) * 1000, 25000);
        this.remain = this.mainSalary - this.advance + this.allowance;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getNumOfWork() {
        return numOfWork;
    }

    public void setNumOfWork(int numOfWork) {
        this.numOfWork = numOfWork;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public int getMainSalary() {
        return mainSalary;
    }

    public void setMainSalary(int mainSalary) {
        this.mainSalary = mainSalary;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.allowance, this.mainSalary, this.advance, this.remain);
    }

    @Override
    public int compareTo(NhanVien o) {
        if (this.mainSalary + this.allowance != o.mainSalary + o.allowance)
            return -Integer.compare(this.mainSalary + this.allowance, o.mainSalary + o.allowance);
        return this.id.compareTo(o.id);
    }
}

public class J05045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for (NhanVien x : a) System.out.println(x);
        sc.close();
    }
}
