import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String name;
    private double gpa;
    private int practiceMark;
    private String rank;

    public SinhVien(String name, double gpa, int practiceMark) {
        this.name = name;
        this.gpa = gpa;
        this.practiceMark = practiceMark;
        this.rank = "KHONG";
    }

    public boolean setRank() {
        if (this.gpa >= 3.6 && this.practiceMark >= 90) {
            this.rank = "XUATSAC";
            return true;
        } else if (this.gpa >= 3.2 && this.practiceMark >= 80) {
            this.rank = "GIOI";
            return true;
        } else if (this.gpa >= 2.5 && this.practiceMark >= 70) {
            this.rank = "KHA";
            return true;
        }
        return false;
    }

    public double getGpa() {
        return gpa;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(SinhVien o) {
        return -Double.compare(this.gpa, o.gpa);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.name, this.rank);
    }
}

public class J05062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new SinhVien(sc.nextLine(), sc.nextDouble(), sc.nextInt()));
        }
        ArrayList<SinhVien> b = new ArrayList<>(a);
        Collections.sort(b);
        int i = 0;
        while (m > 0 && i < n) {
            if (b.get(i).setRank()) {
                m--;
                int j = i + 1;
                while (j < n && b.get(j).getGpa() == b.get(i).getGpa()) {
                    b.get(j).setRank();
                    m--;
                    j++;
                }
                i = j;
            }
        }
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}