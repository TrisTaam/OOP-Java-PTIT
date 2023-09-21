import java.util.*;

class PhongBan {
    private String id;
    private String name;

    public PhongBan(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class NhanVien {
    private String id;
    private String name;
    private String phongBanId;
    private String phongBanName;
    private int salary;

    public NhanVien(String id, String name, int baseSalary, int numOfWorks) {
        this.id = id;
        this.name = name;
        char group = id.charAt(0);
        int numOfYears = Integer.parseInt(id.substring(1, 3));
        this.phongBanId = id.substring(3);
        int coefficient = 0;
        if (group == 'A') {
            if (numOfYears >= 16) coefficient = 20;
            else if (numOfYears >= 9) coefficient = 14;
            else if (numOfYears >= 4) coefficient = 12;
            else coefficient = 10;
        } else if (group == 'B') {
            if (numOfYears >= 16) coefficient = 16;
            else if (numOfYears >= 9) coefficient = 13;
            else if (numOfYears >= 4) coefficient = 11;
            else coefficient = 10;
        } else if (group == 'C') {
            if (numOfYears >= 16) coefficient = 14;
            else if (numOfYears >= 9) coefficient = 12;
            else if (numOfYears >= 4) coefficient = 10;
            else coefficient = 9;
        } else {
            if (numOfYears >= 16) coefficient = 13;
            else if (numOfYears >= 9) coefficient = 11;
            else if (numOfYears >= 4) coefficient = 9;
            else coefficient = 8;
        }
        this.salary = baseSalary * 1000 * numOfWorks * coefficient;
    }

    public String getPhongBanId() {
        return phongBanId;
    }

    public void setPhongBanName(String phongBanName) {
        this.phongBanName = phongBanName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d", this.id, this.name, this.phongBanName, this.salary);
    }
}

public class J05077 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<PhongBan> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            String name = sc.nextLine().trim();
            a.add(new PhongBan(id, name));
        }
        int m = sc.nextInt();
        ArrayList<NhanVien> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int baseSalary = sc.nextInt();
            int numOfWorks = sc.nextInt();
            b.add(new NhanVien(id, name, baseSalary, numOfWorks));
        }
        for (int i = 0; i < m; ++i) {
            for (PhongBan x : a)
                if (b.get(i).getPhongBanId().equals(x.getId())) b.get(i).setPhongBanName(x.getName());
        }
        for (NhanVien x : b) System.out.println(x);
        sc.close();
    }
}