import java.util.*;

class CLB {
    private String id;
    private String name;
    private int price;

    public CLB(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Match {
    private String id;
    private int amount;
    private char nationId;
    private String clbId;
    private int order;
    private int profit;
    private String clbName;

    public Match(String id, int amount) {
        this.id = id;
        this.nationId = id.charAt(0);
        this.clbId = id.substring(1, 3);
        this.order = Integer.parseInt(id.substring(3));
        this.amount = amount;
    }

    public String getClbId() {
        return clbId;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setClbName(String clbName) {
        this.clbName = clbName;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.id, this.clbName, this.profit);
    }
}

public class J05069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<CLB> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            int price = sc.nextInt();
            a.add(new CLB(id, name, price));
        }
        int m = sc.nextInt();
        ArrayList<Match> b = new ArrayList<>();
        for (int i = 0; i < m; ++i) b.add(new Match(sc.next(), sc.nextInt()));
        for (int i = 0; i < m; ++i) {
            for (CLB x : a)
                if (b.get(i).getClbId().equals(x.getId())) {
                    b.get(i).setClbName(x.getName());
                    b.get(i).setProfit(b.get(i).getAmount() * x.getPrice());
                }
        }
        for (Match x : b) System.out.println(x);
        sc.close();
    }
}