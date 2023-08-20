import java.util.*;

class GiaoVien {
    private String id;
    private String name;
    private long baseSalary;
    private long allowance;
    private int coefficient;

    public GiaoVien(String id, String name, long baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        switch (id.substring(0, 2)) {
            case "HT":
                this.allowance = 2000000;
                break;
            case "HP":
                this.allowance = 900000;
                break;
            case "GV":
                this.allowance = 500000;
                break;
            default:
                break;
        }
        this.coefficient = Integer.parseInt(id.substring(2));
    }

    public long getSalary() {
        return this.baseSalary * this.coefficient + this.allowance;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", this.id, this.name, this.coefficient, this.allowance, this.getSalary());
    }
}

public class J04015  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        sc.nextLine();
        String name = sc.nextLine();
        long baseSalary = sc.nextLong();
        GiaoVien a = new GiaoVien(id, name, baseSalary);
        System.out.println(a);
        sc.close();
    }
}