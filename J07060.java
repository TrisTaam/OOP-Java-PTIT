import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class MonThi {
    private String id;
    private String name;
    private String type;

    public MonThi(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class CaThi {
    private static int ID = 0;
    private static final String KEY = "C";
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private String id;
    private Date date;
    private String phongId;

    public CaThi(String date, String time, String phongId) throws ParseException {
        id = String.format("%s%03d", KEY, ++ID);
        this.date = formatter.parse(date + " " + time);
        this.phongId = phongId;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getPhongId() {
        return phongId;
    }
}

class LichThi implements Comparable<LichThi> {
    private CaThi caThi;
    private MonThi monThi;
    private String groupId;
    private int numOfSinhViens;

    public LichThi(String groupId, int numOfSinhViens) {
        this.groupId = groupId;
        this.numOfSinhViens = numOfSinhViens;
    }

    public void setCaThi(CaThi caThi) {
        this.caThi = caThi;
    }

    public void setMonThi(MonThi monThi) {
        this.monThi = monThi;
    }

    @Override
    public int compareTo(LichThi o) {
        if (caThi.getDate().getTime() != o.caThi.getDate().getTime())
            return Long.compare(caThi.getDate().getTime(), o.caThi.getDate().getTime());
        return caThi.getId().compareTo(o.caThi.getId());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d", CaThi.formatter.format(caThi.getDate()), caThi.getPhongId(), monThi.getName(), groupId, numOfSinhViens);
    }
}

public class J07060 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONTHI.in"));
        Scanner sc2 = new Scanner(new File("CATHI.in"));
        Scanner sc3 = new Scanner(new File("LICHTHI.in"));
        int n = sc1.nextInt();
        ArrayList<MonThi> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            String type = sc1.nextLine();
            a.add(new MonThi(id, name, type));
        }
        int m = sc2.nextInt();
        ArrayList<CaThi> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new CaThi(sc2.next(), sc2.next(), sc2.next()));
        int k = sc3.nextInt();
        ArrayList<LichThi> c = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            String caThiId = sc3.next();
            String monThiId = sc3.next();
            String groupId = sc3.next();
            int numOfSinhViens = sc3.nextInt();
            LichThi d = new LichThi(groupId, numOfSinhViens);
            for (CaThi x : b)
                if (x.getId().equals(caThiId)) {
                    d.setCaThi(x);
                    break;
                }
            for (MonThi x : a)
                if (x.getId().equals(monThiId)) {
                    d.setMonThi(x);
                    break;
                }
            c.add(d);
        }
        Collections.sort(c);
        for (LichThi x : c) System.out.println(x);
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
