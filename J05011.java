import java.text.SimpleDateFormat;
import java.util.*;

class Gamer implements Comparable<Gamer> {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
    private String id;
    private String name;
    private Date startDate;
    private Date endDate;

    public Gamer(String id, String name, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        try {
            this.startDate = dateFormat.parse(startDate);
            this.endDate = dateFormat.parse(endDate);
        } catch (Exception e) {

        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getTotalTime() {
        return endDate.getTime() - startDate.getTime();
    }

    @Override
    public int compareTo(Gamer o) {
        return -Long.compare(this.getTotalTime(), o.getTotalTime());
    }

    @Override
    public String toString() {
        return String.format("%s %s %d gio %d phut", this.id, this.name, (int) (this.getTotalTime() / (1000 * 60 * 60)), (int) (this.getTotalTime() / (1000 * 60) % 60));
    }
}

public class J05011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Gamer> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id=sc.next();
            sc.nextLine();
            String name=sc.nextLine();
            String startDate=sc.next();
            String endDate=sc.next();
            a.add(new Gamer(id, name, startDate, endDate));
        }
        Collections.sort(a);
        for (Gamer x : a) System.out.println(x);
        sc.close();
    }
}