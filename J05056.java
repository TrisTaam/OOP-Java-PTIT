import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class VanDongVien implements Comparable<VanDongVien> {
    public static int ID = 0;
    public static final String KEY = "VDV";
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private String id;
    private String name;
    private Date startTime;
    private Date endTime;
    private Date bonusTime;
    private Date realTime;
    private Date finalTime;
    private int rank;

    public VanDongVien(String name, String dob, String startTime, String endTime) throws ParseException {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.startTime = timeFormat.parse(startTime);
        this.endTime = timeFormat.parse(endTime);
        int age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        if (age >= 32) this.bonusTime = timeFormat.parse("00:00:03");
        else if (age >= 25) this.bonusTime = timeFormat.parse("00:00:02");
        else if (age >= 18) this.bonusTime = timeFormat.parse("00:00:01");
        else this.bonusTime = timeFormat.parse("00:00:00");
        this.realTime = MillisToTime(this.endTime.getTime() - this.startTime.getTime());
        this.finalTime = MillisToTime(this.realTime.getTime() - this.bonusTime.getTime());
    }

    public static Date MillisToTime(long millis) throws ParseException {
        int hour = (int) (millis / (1000 * 60 * 60));
        int minute = (int) (millis / (1000 * 60)) % 60;
        int second = (int) (millis / 1000) % 60;
        return timeFormat.parse(String.format("%02d:%02d:%02d", hour, minute, second));
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d", this.id, this.name, timeFormat.format(this.realTime), timeFormat.format(this.bonusTime), timeFormat.format(this.finalTime), this.rank);
    }

    @Override
    public int compareTo(VanDongVien o) {
        return Integer.compare(this.rank, o.rank);
    }
}

public class J05056 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<VanDongVien> a = new ArrayList<>();
        TreeSet<Date> b = new TreeSet<>();
        ArrayList<Date> e = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            VanDongVien c = new VanDongVien(sc.nextLine(), sc.next(), sc.next(), sc.next());
            a.add(c);
            b.add(c.getFinalTime());
            e.add(c.getFinalTime());
        }
        int currentRank = 1;
        HashMap<Date, Integer> d = new HashMap<>();
        for (Date x : b) {
            d.put(x, currentRank);
            currentRank += Collections.frequency(e, x);
        }
        for (VanDongVien x : a) x.setRank(d.get(x.getFinalTime()));
        Collections.sort(a);
        for (VanDongVien x : a) System.out.println(x);
        sc.close();
    }
}
