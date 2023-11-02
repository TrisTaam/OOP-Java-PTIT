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
        this.name = name.trim();
        int order = Integer.parseInt(id);
        if (chucVu.equals("GD") && order > 1) chucVu = "NV";
        else if ((chucVu.equals("TP") || (chucVu.equals("PP"))) && order > 3) chucVu = "NV";
    }

    public String getName() {
        return name;
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

public class J05066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<NhanVien> a = new ArrayList<>();
        int c = 0;
        int d = 0;
        int e = 0;
        for (int i = 0; i < n; ++i) {
            String s = sc.nextLine().trim();
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
        sc.nextLine();
        while (m-- > 0) {
            String s = sc.nextLine().toLowerCase();
            for (NhanVien x : a)
                if (x.getName().toLowerCase().contains(s)) System.out.println(x);
            System.out.println();
        }
        sc.close();
    }
}
