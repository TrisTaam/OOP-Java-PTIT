import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Tram {
    private static int ID = 0;
    private static final String KEY = "T";
    public static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    private String id;
    private String name;
    private double hour;
    private int rainfall;

    public Tram(String name, double hour, int rainfall) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.hour = hour;
        this.rainfall = rainfall;
    }

    public String getName() {
        return name;
    }

    public void addTime(double hour) {
        this.hour += hour;
    }

    public void addRainfall(int rainfall) {
        this.rainfall += rainfall;
    }

    public double getAverageRainfall() {
        return this.rainfall / this.hour;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.id, this.name, this.getAverageRainfall());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.name.equals(((Tram) obj).name);
    }
}

public class J05019 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<Tram> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            Date startTime = Tram.formatter.parse(sc.next());
            Date endTime = Tram.formatter.parse(sc.next());
            double hour = (double) (endTime.getTime() - startTime.getTime()) / (1000 * 60 * 60);
            int rainfall = sc.nextInt();
            boolean kt = false;
            for (Tram x : a)
                if (x.getName().equals(name)) {
                    x.addTime(hour);
                    x.addRainfall(rainfall);
                    kt = true;
                }
            if (!kt) a.add(new Tram(name, hour, rainfall));
        }
        for (Tram x : a) System.out.println(x);
        sc.close();
    }
}