import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DonThuc implements Comparable<DonThuc> {
    private final Pattern pattern = Pattern.compile("(\\d+)\\*x\\^(\\d+)");
    private int heSo;
    private int soMu;

    public DonThuc(int heSo, int soMu) {
        this.heSo = heSo;
        this.soMu = soMu;
    }

    public DonThuc(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            this.heSo = Integer.parseInt(matcher.group(1));
            this.soMu = Integer.parseInt(matcher.group(2));
        }
    }

    public int getHeSo() {
        return heSo;
    }

    public int getSoMu() {
        return soMu;
    }

    @Override
    public String toString() {
        return String.format("%d*x^%d", this.heSo, this.soMu);
    }

    @Override
    public int compareTo(DonThuc o) {
        return -Integer.compare(this.soMu, o.soMu);
    }
}

class DaThuc {
    private ArrayList<DonThuc> daThuc;

    public DaThuc(String str) {
        this.daThuc = new ArrayList<>();
        String[] tmp = str.split("\\s\\+\\s");
        for (int i = 0; i < tmp.length; ++i) this.daThuc.add(new DonThuc(tmp[i]));
    }

    public DaThuc(ArrayList<DonThuc> donThucs) {
        Collections.sort(donThucs);
        this.daThuc = donThucs;
    }

    public DaThuc cong(DaThuc o) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (DonThuc x : this.daThuc) hashMap.put(x.getSoMu(), hashMap.getOrDefault(x.getSoMu(), 0) + x.getHeSo());
        for (DonThuc x : o.daThuc) hashMap.put(x.getSoMu(), hashMap.getOrDefault(x.getSoMu(), 0) + x.getHeSo());
        ArrayList<DonThuc> donThucs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> x : hashMap.entrySet()) donThucs.add(new DonThuc(x.getValue(), x.getKey()));
        return new DaThuc(donThucs);
    }

    @Override
    public String toString() {
        String s = this.daThuc.get(0).toString();
        for (int i = 1; i < this.daThuc.size(); ++i) s += String.format(" + %s", this.daThuc.get(i).toString());
        return s;
    }
}

public class J05063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
}