import java.util.*;

class NhanVien {
    public static int ID = 0;
    public static final String KEY = "NV";
    private String id;
    private String name;
    private int baseSalary;
    private int workDay;
    private String position;
    private int salary;
    private int bonus;
    private int allowance;

    public NhanVien(String name, int baseSalary, int workDay, String position) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.baseSalary = baseSalary;
        this.workDay = workDay;
        this.position = position;
        this.salary = this.baseSalary * this.workDay;
        if (workDay >= 25) this.bonus = (int) (this.salary * 0.2);
        else if (workDay >= 22) this.bonus = (int) (this.salary * 0.1);
        else this.bonus = 0;
        switch (position) {
            case "GD":
                this.allowance = 250000;
                break;
            case "PGD":
                this.allowance = 200000;
                break;
            case "TP":
                this.allowance = 180000;
                break;
            case "NV":
                this.allowance = 150000;
                break;
            default:
                break;
        }
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

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFinalSalary() {
        return this.salary + this.bonus + this.allowance;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", this.id, this.name, this.salary, this.bonus, this.allowance, this.getFinalSalary());
    }
}

public class J05038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new NhanVien(sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.next()));
        }
        int s = 0;
        for (NhanVien x : a) {
            s += x.getFinalSalary();
            System.out.println(x);
        }
        System.out.printf("Tong chi phi tien luong: %d", s);
        sc.close();
    }
}
