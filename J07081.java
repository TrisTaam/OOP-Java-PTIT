import java.io.*;
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String email;

    public SinhVien(String id, String name, String phone, String email) {
        this.id = id;
        String[] tmp = name.split("\\s+");
        this.name = tmp[0];
        for (int i = 1; i < tmp.length; ++i) this.name += (" " + tmp[i]);
        this.lastName = tmp[0];
        this.firstName = tmp[tmp.length - 1];
        if (tmp.length > 2) {
            this.middleName = tmp[1];
            for (int i = 2; i < tmp.length; ++i) this.middleName += (" " + tmp[i]);
        } else this.middleName = "";
        this.phone = phone;
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(SinhVien o) {
        if (!this.firstName.equals(o.firstName)) return this.firstName.compareTo(o.firstName);
        if (!this.lastName.equals(o.lastName)) return this.lastName.compareTo(o.lastName);
        if (!this.middleName.equals(o.middleName)) return this.middleName.compareTo(o.middleName);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.name, this.phone, this.email);
    }
}

public class J07081 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String phone = sc.next();
            String email = sc.next();
            a.add(new SinhVien(id, name, phone, email));
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
    }
}
