import java.util.*;

class HocSinh {
    public static int ID = 0;
    public static final String KEY = "HS";
    private String id;
    private String name;
    private float averageMark;
    private String classification;
    private int rank;

    public HocSinh(String name, float averageMark) {
        this.id = String.format("%s%02d", KEY, ++ID);
        this.name = name;
        this.averageMark = averageMark;
        if (averageMark >= 9.f) this.classification = "Gioi";
        else if (averageMark >= 7.f) this.classification = "Kha";
        else if (averageMark >= 5.f) this.classification = "Trung Binh";
        else this.classification = "Yeu";
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

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s %d", this.id, this.name, this.averageMark, this.classification, this.rank);
    }
}

public class J05054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        int n = sc.nextInt();
        ArrayList<HocSinh> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            sc.nextLine();
            a.add(new HocSinh(sc.nextLine(), sc.nextFloat()));
        }
        Collections.sort(a, new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return -Float.compare(o1.getAverageMark(), o2.getAverageMark());
            }
        });
        int currentRank = 0;
        float currentMark = 0.f;
        int tmp = 0;
        for (int i = 0; i < a.size(); ++i)
            if (currentMark == a.get(i).getAverageMark()) {
                a.get(i).setRank(currentRank);
                tmp += 1;
            } else {
                currentMark = a.get(i).getAverageMark();
                currentRank += (tmp + 1);
                tmp = 0;
                a.get(i).setRank(currentRank);
            }
        Collections.sort(a, new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        for (HocSinh x : a) System.out.println(x);
        sc.close();
    }
}
