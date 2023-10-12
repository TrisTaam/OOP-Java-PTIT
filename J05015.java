import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class CuaRo implements Comparable<CuaRo> {
    private final SimpleDateFormat formatter = new SimpleDateFormat("h:mm");
    private final Date startTime = formatter.parse("6:00");
    private final int distance = 120;
    private String id;
    private String name;
    private String unit;
    private Date endTime;
    private float speed;

    public CuaRo(String name, String unit, String end) throws ParseException {
        this.name = name;
        this.unit = unit;
        this.id = shortcut(unit) + shortcut(name);
        this.endTime = formatter.parse(end);
        float totalTime = (float) (endTime.getTime() - startTime.getTime()) / (1000 * 60 * 60);
        this.speed = distance / totalTime;
    }

    public static String shortcut(String s) {
        String[] tmp = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String x : tmp) ans.append(x.substring(0, 1).toUpperCase());
        return ans.toString();
    }

    @Override
    public int compareTo(CuaRo o) {
        return -Float.compare(this.speed, o.speed);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d Km/h", this.id, this.name, this.unit, Math.round(this.speed));
    }
}

public class J05015 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<CuaRo> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new CuaRo(sc.nextLine(), sc.nextLine(), sc.next()));
        }
        Collections.sort(a);
        for (CuaRo x : a) System.out.println(x);
        sc.close();
    }
}