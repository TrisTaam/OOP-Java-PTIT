import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class GiaoVien implements Comparable<GiaoVien> {
    private static int ID = 0;
    private static final String KEY = "GV";
    private String id;
    private String name;
    private double computerMark;
    private double specialMark;
    private String subject;
    private double finalMark;
    private String status;

    public GiaoVien(String name, String admissionId, double computerMark, double specialMark) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.computerMark = computerMark;
        this.specialMark = specialMark;
        switch (admissionId.charAt(0)) {
            case 'A':
                this.subject = "TOAN";
                break;
            case 'B':
                this.subject = "LY";
                break;
            case 'C':
                this.subject = "HOA";
                break;
        }
        double priorityMark = 0;
        switch (admissionId.charAt(1)) {
            case '1':
                priorityMark = 2;
                break;
            case '2':
                priorityMark = 1.5;
                break;
            case '3':
                priorityMark = 1;
                break;
            case '4':
                priorityMark = 0;
                break;
        }
        this.finalMark = computerMark * 2 + specialMark + priorityMark;
        if (this.finalMark >= 18) this.status = "TRUNG TUYEN";
        else this.status = "LOAI";
    }

    @Override
    public int compareTo(GiaoVien o) {
        if (this.finalMark != o.finalMark) return -Double.compare(this.finalMark, o.finalMark);
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.1f %s", this.id, this.name, this.subject, this.finalMark, this.status);
    }
}

public class J05014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<GiaoVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new GiaoVien(sc.nextLine(), sc.next(), sc.nextDouble(), sc.nextDouble()));
        }
        Collections.sort(a);
        for (GiaoVien x : a) System.out.println(x);
        sc.close();
    }
}