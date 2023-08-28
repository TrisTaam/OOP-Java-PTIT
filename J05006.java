import java.util.*;

class NhanVien {
    public static int ID = 0;
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;
    private String taxCode;
    private String signDate;

    public NhanVien(String name, String gender, String dob, String address, String taxCode, String signDate) {
        this.id = String.format("%05d", ++ID);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.taxCode = taxCode;
        this.signDate = signDate;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s", this.id, this.name, this.gender, this.dob, this.address, this.taxCode, this.signDate);
    }
}

public class J05006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            String gender = sc.next();
            String dob = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            String taxCode = sc.next();
            String signDate = sc.next();
            NhanVien a = new NhanVien(name, gender, dob, address, taxCode, signDate);
            System.out.println(a);
        }
        sc.close();
    }
}