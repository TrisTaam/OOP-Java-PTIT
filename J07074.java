import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MonHoc {
    private String id;
    private String name;
    private int credits;

    public MonHoc(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class HocPhan implements Comparable<HocPhan> {
    private static int ID = 0;
    private static final String KEY = "HP";
    private String id;
    private MonHoc monHoc;
    private int day;
    private int time;
    private String teacherName;
    private String room;

    public HocPhan(int day, int time, String teacherName, String room) {
        this.id = String.format("%s%03d", KEY, ++ID);
        this.day = day;
        this.time = time;
        this.teacherName = teacherName;
        this.room = room;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    @Override
    public int compareTo(HocPhan o) {
        if (day != o.day) return Integer.compare(day, o.day);
        if (time != o.time) return Integer.compare(time, o.time);
        return teacherName.compareTo(o.teacherName);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %s %s", id, day, time, teacherName, room);
    }
}

public class J07074 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        int n = sc1.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            int credits = sc1.nextInt();
            a.add(new MonHoc(id, name, credits));
        }
        int m = sc2.nextInt();
        ArrayList<HocPhan> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String monHocId = sc2.next();
            int day = sc2.nextInt();
            int time = sc2.nextInt();
            sc2.nextLine();
            String teacherName = sc2.nextLine();
            String room = sc2.next();
            HocPhan c = new HocPhan(day, time, teacherName, room);
            for (MonHoc x : a)
                if (x.getId().equals(monHocId)) {
                    c.setMonHoc(x);
                    break;
                }
            b.add(c);
        }
        Collections.sort(b);
        String id = sc2.next();
        String name = "";
        for (MonHoc x : a)
            if (x.getId().equals(id)) {
                name = x.getName();
                break;
            }
        System.out.printf("LICH GIANG DAY MON %s:\n", name);
        for (HocPhan x : b)
            if (x.getMonHoc().getId().equals(id)) System.out.println(x);
        sc1.close();
        sc2.close();
    }
}
