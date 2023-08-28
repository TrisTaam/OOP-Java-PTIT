import java.util.*;

class ThiSinh implements Comparable<ThiSinh> {
    private String id;
    private String name;
    private float toan;
    private float ly;
    private float hoa;
    private float bonus;
    private String status;

    public ThiSinh(String id, String name, float toan, float ly, float hoa) {
        this.id = id;
        this.name = name;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        switch (id.charAt(2)) {
            case '1':
                this.bonus = 0.5f;
                break;
            case '2':
                this.bonus = 1f;
                break;
            case '3':
                this.bonus = 2.5f;
                break;
            default:
                break;
        }
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

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getMark() {
        return this.toan * 2 + this.ly + this.hoa;
    }

    public float getTotalMark() {
        return this.toan * 2 + this.ly + this.hoa + this.bonus;
    }

    @Override
    public int compareTo(ThiSinh o) {
        return -Float.compare(this.getMark(), o.getMark());
    }

    @Override
    public String toString() {
        return  this.id + " " +
                this.name + " " +
                ((int) this.bonus == this.bonus ? String.format("%d", (int) this.bonus) : String.format("%.1f", this.bonus)) + " " +
                ((int) this.getMark() == this.getMark() ? String.format("%d", (int) this.getMark()) : String.format("%.1f", this.getMark())) + " " +
                this.status;
    }
}

public class J04013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        String id = sc.next();
        sc.nextLine();
        String name = sc.nextLine();
        float toan = sc.nextFloat();
        float ly = sc.nextFloat();
        float hoa = sc.nextFloat();
        ThiSinh a = new ThiSinh(id, name, toan, ly, hoa);
        a.setStatus(a.getTotalMark() >= 24f ? "TRUNG TUYEN" : "TRUOT");
        System.out.println(a);
    }
}
