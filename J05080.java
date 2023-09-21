import java.util.*;

class LopHoc implements Comparable<LopHoc> {
    private String subjectId;
    private String subjectName;
    private String group;
    private String teacherName;

    public LopHoc(String subjectId, String subjectName, String group, String teacherName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.group = group;
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public int compareTo(LopHoc o) {
        if (!this.subjectId.equals(o.subjectId)) return this.subjectId.compareTo(o.subjectId);
        return this.group.compareTo(o.group);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.subjectId, this.subjectName, this.group);
    }
}

public class J05080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<LopHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String subjectId = sc.next();
            sc.nextLine();
            String subjectName = sc.nextLine();
            String group = sc.next();
            sc.nextLine();
            String teacherName = sc.nextLine();
            a.add(new LopHoc(subjectId, subjectName, group, teacherName));
        }
        Collections.sort(a);
        int m = sc.nextInt();
        sc.nextLine();
        while (m-- > 0) {
            String name = sc.nextLine();
            System.out.printf("Danh sach cho giang vien %s:\n", name);
            for (LopHoc x : a)
                if (x.getTeacherName().equals(name)) System.out.println(x);
        }
        sc.close();
    }
}