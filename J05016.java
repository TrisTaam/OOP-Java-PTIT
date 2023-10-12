import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String roomId;
    private Date startDate;
    private Date endDate;
    private int otherPrice;
    private int unitPrice;
    private int amount;
    private int finalPrice;

    public KhachHang(String name, String roomId, String start, String end, int otherPrice) throws ParseException {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.roomId = roomId;
        this.startDate = formatter.parse(start);
        this.endDate = formatter.parse(end);
        this.otherPrice = otherPrice;
        this.amount = (int) ((this.endDate.getTime() - this.startDate.getTime()) / (1000 * 60 * 60 * 24) + 1);
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
        }
        this.finalPrice = this.unitPrice * this.amount + this.otherPrice;
    }

    @Override
    public int compareTo(KhachHang o) {
        return -Integer.compare(this.finalPrice, o.finalPrice);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", this.id, this.name, this.roomId, this.amount, this.finalPrice);
    }
}

public class J05016 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<KhachHang> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new KhachHang(sc.nextLine(), sc.next(), sc.next(), sc.next(), sc.nextInt()));
        }
        Collections.sort(a);
        for (KhachHang x : a) System.out.println(x);
        sc.close();
    }
}