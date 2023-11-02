import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class SanPham {
    private String id;
    private String name;
    private int unitPrice;
    private int guarantee;

    public SanPham(String id, String name, int unitPrice, int guarantee) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.guarantee = guarantee;
    }

    public String getId() {
        return id;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getGuarantee() {
        return guarantee;
    }
}

class KhachHang implements Comparable<KhachHang> {
    private static int ID = 0;
    private static final String KEY = "KH";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String id;
    private String name;
    private String address;
    private SanPham sanPham;
    private int amount;
    private Date buyDate;
    private Date overDueDate;

    public KhachHang(String name, String address, int amount, String buy) throws ParseException {
        id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.address = address;
        this.amount = amount;
        buyDate = formatter.parse(buy);
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(buyDate);
        calendar.add(Calendar.MONTH, sanPham.getGuarantee());
        overDueDate = calendar.getTime();
    }

    public int getPrice() {
        return amount * sanPham.getUnitPrice();
    }

    @Override
    public int compareTo(KhachHang o) {
        if (overDueDate.getTime() != o.overDueDate.getTime())
            return Long.compare(overDueDate.getTime(), o.overDueDate.getTime());
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %s", id, name, address, sanPham.getId(), getPrice(), formatter.format(overDueDate));
    }
}

public class J07049 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = sc.nextInt();
        ArrayList<SanPham> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int unitPrice = sc.nextInt();
            int guarantee = sc.nextInt();
            a.add(new SanPham(id, name, unitPrice, guarantee));
        }
        int m = sc.nextInt();
        ArrayList<KhachHang> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            sc.nextLine();
            String name = sc.nextLine();
            String address = sc.nextLine();
            String sanPhamId = sc.next();
            int amount = sc.nextInt();
            String buy = sc.next();
            KhachHang c = new KhachHang(name, address, amount, buy);
            for (SanPham x : a)
                if (x.getId().equals(sanPhamId)) {
                    c.setSanPham(x);
                    break;
                }
            b.add(c);
        }
        Collections.sort(b);
        for (KhachHang x : b) System.out.println(x);
        sc.close();
    }
}
