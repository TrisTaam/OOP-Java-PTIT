import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class CaThi implements Comparable<CaThi> {
    public static int ID = 0;
    public static final String KEY = "C";
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private String id;
    private String date;
    private String time;
    private String roomID;

    public CaThi(String date, String time, String roomID) {
        this.id = String.format("%s%03d", KEY, ++ID);
        this.date = date;
        this.time = time;
        this.roomID = roomID;
    }

    public static void setID(int ID) {
        CaThi.ID = ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    @Override
    public int compareTo(CaThi o) {
        try {
            long x = dateFormat.parse(this.date + " " + this.time).getTime();
            long y = dateFormat.parse(o.date + " " + o.time).getTime();
            if (x != y) return Long.compare(x, y);
            return this.id.compareTo(o.id);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", this.id, this.date, this.time, this.roomID);
    }
}

public class J07059 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        ArrayList<CaThi> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) a.add(new CaThi(sc.next(), sc.next(), sc.next()));
        Collections.sort(a);
        for (CaThi x : a) System.out.println(x);
    }
}
