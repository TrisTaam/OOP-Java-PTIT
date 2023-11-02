import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Tinh {
    private String id;
    private String name;
    private int unitPrice;

    public Tinh(String id, String name, int unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}

class CuocGoi {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    private String thueBao;
    private Tinh tinh;
    private int numOfMinutes;
    private int price;

    public CuocGoi(String thueBao, String start, String end) throws ParseException {
        this.thueBao = thueBao;
        Date startTime = formatter.parse(start);
        Date endTime = formatter.parse(end);
        numOfMinutes = (int) ((endTime.getTime() - startTime.getTime()) / (1000 * 60));
    }

    public void setTinh(Tinh tinh) {
        this.tinh = tinh;
        if (tinh.getName().equals("Noi mang")) numOfMinutes = (int) Math.ceil(numOfMinutes / 3.0);
        price = tinh.getUnitPrice() * numOfMinutes;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", thueBao, tinh.getName(), numOfMinutes, price);
    }
}

public class J05071 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Tinh> a = new ArrayList<>();
        a.add(new Tinh("0", "Noi mang", 800));
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int unitPrice = sc.nextInt();
            a.add(new Tinh(id, name, unitPrice));
        }
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<CuocGoi> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            String[] tmp = sc.nextLine().split("\\s+");
            CuocGoi c = new CuocGoi(tmp[0], tmp[1], tmp[2]);
            if (tmp[0].charAt(0) != '0') c.setTinh(a.get(0));
            else
                for (Tinh x : a)
                    if (x.getId().equals(tmp[0].substring(1, 3))) {
                        c.setTinh(x);
                        break;
                    }
            b.add(c);
        }
        for (CuocGoi x : b) System.out.println(x);
        sc.close();
    }
}
