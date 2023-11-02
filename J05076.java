import java.util.ArrayList;
import java.util.Scanner;

class HangHoa {
    private String id;
    private String name;
    private char rank;

    public HangHoa(String id, String name, char rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getRank() {
        return rank;
    }
}

public class J05076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<HangHoa> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            char rank = sc.next().charAt(0);
            a.add(new HangHoa(id, name, rank));
        }
        int m = sc.nextInt();
        while (m-- > 0) {
            String id = sc.next();
            int importAmount = sc.nextInt();
            int unitPrice = sc.nextInt();
            int exportAmount = sc.nextInt();
            for (HangHoa x : a)
                if (x.getId().equals(id)) {
                    int importPrice = importAmount * unitPrice;
                    int exportPrice = exportAmount * unitPrice;
                    switch (x.getRank()) {
                        case 'A':
                            exportPrice = (int) (exportPrice * (1 + 0.08));
                            break;
                        case 'B':
                            exportPrice = (int) (exportPrice * (1 + 0.05));
                            break;
                        case 'C':
                            exportPrice = (int) (exportPrice * (1 + 0.02));
                            break;
                        default:
                            break;
                    }
                    System.out.printf("%s %s %d %d\n", x.getId(), x.getName(), importPrice, exportPrice);
                    break;
                }
        }
        sc.close();
    }
}