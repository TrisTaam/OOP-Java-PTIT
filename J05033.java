import java.util.*;

class Time implements Comparable<Time> {
    private Byte hour;
    private Byte minute;
    private Byte second;

    public Time(Byte hour, Byte minute, Byte second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Byte getHour() {
        return hour;
    }

    public void setHour(Byte hour) {
        this.hour = hour;
    }

    public Byte getMinute() {
        return minute;
    }

    public void setMinute(Byte minute) {
        this.minute = minute;
    }

    public Byte getSecond() {
        return second;
    }

    public void setSecond(Byte second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.hour, this.minute, this.second);
    }

    @Override
    public int compareTo(Time o) {
        if (this.hour != o.hour)
            return this.hour.compareTo(o.hour);
        if (this.minute != o.minute)
            return this.minute.compareTo(o.minute);
        return this.second.compareTo(o.second);
    }
}

public class J05033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> a = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            a.add(new Time(sc.nextByte(), sc.nextByte(), sc.nextByte()));
        Collections.sort(a);
        for (Time x : a)
            System.out.println(x);
        sc.close();
    }
}