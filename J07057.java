import java.io.*;
import java.util.*;

class ThiSinh implements Comparable<ThiSinh> {
    public static int ID = 0;
    public static final String KEY = "TS";
    private String id;
    private String name;
    private float mark;
    private String status;

    public ThiSinh(String name, float mark, String ethnic, int area) {
        this.id = String.format("%s%02d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.mark = mark;
        if (area == 1) this.mark += 1.5f;
        else if (area == 2) this.mark += 1;
        if (!ethnic.equals("Kinh")) this.mark += 1.5f;
        this.status = (this.mark >= 20.5f ? "Do" : "Truot");
    }

    @Override
    public int compareTo(ThiSinh o) {
        if (this.mark != o.mark) return -Float.compare(this.mark, o.mark);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", this.id, this.name, this.mark, this.status);
    }
}

public class J07057 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("THISINH.in")).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<ThiSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            float mark = sc.nextFloat();
            sc.nextLine();
            String ethnic = sc.nextLine();
            int area = sc.nextInt();
            a.add(new ThiSinh(name, mark, ethnic, area));
        }
        Collections.sort(a);
        for (ThiSinh x : a) System.out.println(x);
    }
}
