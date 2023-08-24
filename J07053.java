import java.io.*;
import java.util.*;

class ThiSinh {
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

    public ThiSinh(String name, String dob, float theory, float practice) {
        this.id = String.format("%s%02d", KEY, ++ID);
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        this.name = tmp[0].substring(0, 1).toUpperCase() + tmp[0].substring(1);
        for (int i = 1; i < tmp.length; ++i)
            this.name += (" " + tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1));
        this.age = 2021 - Integer.parseInt(dob.substring(dob.length() - 4));
        this.theory = theory;
        this.practice = practice;
        if (theory >= 8 && practice >= 8) this.bonus = 1f;
        else if (theory >= 7.5 && practice >= 7.5) this.bonus = 0.5f;
        this.finalMark = (int) Math.round((this.theory + this.practice) / 2 + this.bonus);
        if (this.finalMark > 10) this.finalMark = 10;
        if (this.finalMark < 5) this.rank = "Truot";
        else if (this.finalMark < 7) this.rank = "Trung binh";
        else if (this.finalMark < 8) this.rank = "Kha";
        else if (this.finalMark < 9) this.rank = "Gioi";
        else this.rank = "Xuat sac";
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }

    public float getTheory() {
        return theory;
    }

    public void setTheory(float theory) {
        this.theory = theory;
    }

    public float getPractice() {
        return practice;
    }

    public void setPractice(float practice) {
        this.practice = practice;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %s", this.id, this.name, this.age, this.finalMark, this.rank);
    }
}

public class J07053 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("XETTUYEN.in")).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<ThiSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new ThiSinh(sc.nextLine(), sc.next(), sc.nextFloat(), sc.nextFloat()));
        }
        for (ThiSinh x : a) System.out.println(x);
    }
}
