import java.io.*;
import java.util.*;

class GiangVien implements Comparable<GiangVien> {
    public static int ID = 0;
    public static final String KEY = "GV";
    private String id;
    private String name;
    private String firstName;
    private String subject;

    public GiangVien(String name, String subject) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.firstName = "";
        for (int i = name.length() - 1; i >= 0 && name.charAt(i) != ' '; --i)
            this.firstName = name.charAt(i) + this.firstName;
        String[] tmp = subject.toUpperCase().split("\\s+");
        this.subject = "";
        for (String x : tmp) this.subject += x.charAt(0);
    }

    @Override
    public int compareTo(GiangVien o) {
        if (!this.firstName.equals(o.firstName)) return this.firstName.compareTo(o.firstName);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.subject);
    }
}

public class J05025 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<GiangVien> a = new ArrayList<GiangVien>();
        for (int i = 0; i < n; ++i) a.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        Collections.sort(a);
        for (GiangVien x : a) System.out.println(x);
        sc.close();
    }
}
