import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    public static int NUM = 0;
    private int stt;
    private String id;
    private String name;
    private String grade;
    private String email;
    private String company;

    public SinhVien(String id, String name, String grade, String email, String company) {
        this.stt = ++NUM;
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.company = company;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s", this.stt, this.id, this.name, this.grade, this.email, this.company);
    }
}

public class J05035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<SinhVien>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            String email = sc.next();
            String company = sc.next();
            a.add(new SinhVien(id, name, grade, email, company));
        }
        Collections.sort(a);
        int q = sc.nextInt();
        while (q-- > 0) {
            String company = sc.next();
            for (SinhVien x : a)
                if (x.getCompany().equals(company)) System.out.println(x);
        }
        sc.close();
    }
}
