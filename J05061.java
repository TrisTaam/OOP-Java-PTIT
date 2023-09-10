import java.util.*;

class PhuHo implements Comparable<PhuHo> {
    public static int ID = 0;
    public static final String KEY = "PH";
    private String id;
    private String name;
    private int age;
    private float theory;
    private float practice;
    private float bonus;
    private int finalMark;
    private String rank;

    public PhuHo(String name, String dob, float theory, float practice) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        this.theory = theory;
        this.practice = practice;
        if (theory >= 8.f && practice >= 8.f) this.bonus = 1.f;
        else if (theory >= 7.5f && practice >= 7.5f) this.bonus = 0.5f;
        else this.bonus = 0.f;
        this.finalMark = Math.min(10, Math.round((this.theory + this.practice) / 2 + this.bonus));
        if (this.finalMark >= 9) this.rank = "Xuat sac";
        else if (this.finalMark == 8) this.rank = "Gioi";
        else if (this.finalMark == 7) this.rank = "Kha";
        else if (this.finalMark >= 5) this.rank = "Trung binh";
        else this.rank = "Truot";
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %s", this.id, this.name, this.age, this.finalMark, this.rank);
    }

    @Override
    public int compareTo(PhuHo o) {
        if (this.finalMark != o.finalMark) return -Integer.compare(this.finalMark, o.finalMark);
        return this.id.compareTo(o.id);
    }
}

public class J05061 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<PhuHo> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new PhuHo(sc.nextLine(), sc.next(), sc.nextFloat(), sc.nextFloat()));
        }
        Collections.sort(a);
        for (PhuHo x : a) System.out.println(x);
        sc.close();
    }
}
