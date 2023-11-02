import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NhanVien implements Comparable<NhanVien> {
    private String chucVu;
    private String heSoLuong;
    private String id;
    private String name;

    public NhanVien(String idStr, String name) {
        chucVu = idStr.substring(0, 2);
        heSoLuong = idStr.substring(2, 4);
        id = idStr.substring(4);
        this.name = name;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public int compareTo(NhanVien o) {
        if (!heSoLuong.equals(o.heSoLuong)) return -heSoLuong.compareTo(o.heSoLuong);
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", name, chucVu, id, heSoLuong);
    }
}

public class J05065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<NhanVien> a = new ArrayList<>();
        int c = 0;
        int d = 0;
        int e = 0;
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String s = sc.nextLine();
            String idStr = "";
            String name = "";
            for (int j = 0; j < s.length(); ++j)
                if (s.charAt(j) != ' ') idStr += s.charAt(j);
                else {
                    name = s.substring(j + 1);
                    break;
                }
            NhanVien b = new NhanVien(idStr, name);
            if (idStr.contains("GD")) {
                if (c < 1) c++;
                else b.setChucVu("NV");
            } else if (idStr.contains("TP")) {
                if (d < 3) d++;
                else b.setChucVu("NV");
            } else if (idStr.contains("PP")) {
                if (e < 3) e++;
                else b.setChucVu("NV");
            }
            a.add(b);
        }
        Collections.sort(a);
        int m = sc.nextInt();
        while (m-- > 0) {
            String s = sc.next();
            for (NhanVien x : a)
                if (x.getChucVu().equals(s)) System.out.println(x);
            System.out.println();
        }
        sc.close();
    }
}
