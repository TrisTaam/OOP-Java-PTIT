import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class Khach implements Comparable<Khach> {
    public static int ID = 0;
    public static final String KEY = "KH";
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String roomId;
    private Date startDate;
    private Date endDate;

    public Khach(String name, String roomId, String startDate, String endDate) {
        this.id = Integer.toString(++ID);
        while (this.id.length() < 2) this.id = "0" + this.id;
        this.id = KEY + this.id;
        this.name = name;
        this.roomId = roomId;
        try {
            this.startDate = dateFormat.parse(startDate);
            this.endDate = dateFormat.parse(endDate);
        } catch (Exception e) {

        }
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Khach.ID = ID;
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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

    public int getNumOfDate() {
        return (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d", this.id, this.name, this.roomId, this.getNumOfDate());
    }

    @Override
    public int compareTo(Khach o) {
        return -Integer.compare(this.getNumOfDate(), o.getNumOfDate());
    }
}

public class J07046 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int n = sc.nextInt();
        ArrayList<Khach> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new Khach(sc.nextLine(), sc.next(), sc.next(), sc.next()));
        }
        Collections.sort(a);
        for (Khach x : a) System.out.println(x);
    }
}
