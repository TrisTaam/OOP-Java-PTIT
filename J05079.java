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

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public int compareTo(LopHoc o) {
        return this.group.compareTo(o.group);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.group, this.teacherName);
    }
}

public class J05079 {
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
        while (m-- > 0) {
            String id = sc.next();
            String name = "";
            for (LopHoc x : a)
                if (x.getSubjectId().equals(id)) name = x.getSubjectName();
            System.out.printf("Danh sach nhom lop mon %s:\n", name);
            for (LopHoc x : a)
                if (x.getSubjectId().equals(id)) System.out.println(x);
        }
        sc.close();
    }
}