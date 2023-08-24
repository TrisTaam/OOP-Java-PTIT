import java.io.*;
import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    public static int ID = 0;
    public static final String KEY = "KH";
    private String id;
    private String name;
    private String roomId;
    private Date startDate;
    private Date endDate;
    private int servicePrice;
    private int unitPrice;

    public KhachHang(String name, String roomId, String startDate, String endDate, int servicePrice) {
        this.id = String.format("%s%02d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.roomId = roomId;
        this.startDate = getDateFromString(startDate);
        this.endDate = getDateFromString(endDate);
        this.servicePrice = servicePrice;
        switch (roomId.charAt(0)) {
            case '1':
                this.unitPrice = 25;
                break;
            case '2':
                this.unitPrice = 34;
                break;
            case '3':
                this.unitPrice = 50;
                break;
            case '4':
                this.unitPrice = 80;
                break;
            default:
                break;
        }
    }

    public static Date getDateFromString(String date) {
        String[] tmp = date.split("/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, Integer.parseInt(tmp[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(tmp[1]));
        calendar.set(Calendar.YEAR, Integer.parseInt(tmp[2]));
        return calendar.getTime();
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

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getDiff() {
        return (int) ((this.endDate.getTime() - this.startDate.getTime()) / (1000 * 60 * 60 * 24)) + 1;
    }

    public int getSum() {
        return unitPrice * this.getDiff() + servicePrice;
    }

    @Override
    public int compareTo(KhachHang o) {
        return -Integer.compare(this.getSum(), o.getSum());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", this.id, this.name, this.roomId, this.getDiff(), this.getSum());
    }
}

public class J07051 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new KhachHang(sc.nextLine(), sc.next(), sc.next(), sc.next(), sc.nextInt()));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
    }
}
