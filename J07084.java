import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String name;
    private Date startTime;
    private Date endTime;

    public SinhVien(String name, String startTime, String endTime) {
        this.name = name;
        try {
            this.startTime = dateFormat.parse(startTime);
            this.endTime = dateFormat.parse(endTime);
        } catch (Exception e) {
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long totalTime() {
        return endTime.getTime() - startTime.getTime();
    }

    @Override
    public int compareTo(SinhVien o) {
        if (this.totalTime() != o.totalTime()) return -Long.compare(this.totalTime(), o.totalTime());
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, (int) (this.totalTime() / (1000 * 60)));
    }
}

public class J07084 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            a.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(a);
        for (SinhVien x : a) System.out.println(x);
    }
}
