import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String grade;
    private int mark;
    private String note;

    public SinhVien(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mark = 10;
        this.note = "";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setMark(String data) {
        for (int i = 0; i < data.length(); ++i)
            if (data.charAt(i) == 'm') this.mark--;
            else if (data.charAt(i) == 'v') this.mark -= 2;
        this.mark = Math.max(this.mark, 0);
        if (this.mark == 0) this.note = "KDDK";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s", this.id, this.name, this.grade, this.mark, this.note);
    }
}

public class J05074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            String grade = sc.next();
            a.add(new SinhVien(id, name, grade));
        }
        for (int i = 0; i < n; ++i) {
            String svID = sc.next();
            for (int j = 0; j < n; ++j)
                if (a.get(j).getId().equals(svID)) a.get(j).setMark(sc.next());
        }
        for (SinhVien x : a) System.out.println(x);
        sc.close();
    }
}