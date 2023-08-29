import java.io.*;
import java.util.*;

class GiangVien {
    public static int ID = 0;
    public static final String KEY = "GV";
    private String id;
    private String name;
    private String subject;

    public GiangVien(String name, String subject) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.subject = GiangVien.convertSubject(subject);
    }

    public static String convertSubject(String s) {
        String[] tmp = s.toUpperCase().split("\\s+");
        String ans = "";
        for (String x : tmp) ans += x.charAt(0);
        return ans;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.subject);
    }
}

public class J05027 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<GiangVien> a = new ArrayList<GiangVien>();
        for (int i = 0; i < n; ++i) a.add(new GiangVien(sc.nextLine(), sc.nextLine()));
        int q = sc.nextInt();
        sc.nextLine();
        while (q-- > 0) {
            String keyWord = sc.nextLine();
            System.out.printf("DANH SACH GIANG VIEN THEO TU KHOA %s:\n", keyWord);
            for (GiangVien x : a)
                if (x.getName().toLowerCase().contains(keyWord.toLowerCase())) System.out.println(x);
        }
        sc.close();
    }
}
