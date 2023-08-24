import java.io.*;
import java.util.*;

class MonHoc implements Comparable<MonHoc> {
    private String id;
    private String name;
    private byte value;

    public MonHoc(String id, String name, byte value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    @Override
    public int compareTo(MonHoc o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.value);
    }
}

public class J07034 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = sc.nextInt();
        ArrayList<MonHoc> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = sc.next();
            sc.nextLine();
            String name = sc.nextLine();
            byte value = sc.nextByte();
            a.add(new MonHoc(id, name, value));
        }
        Collections.sort(a);
        for (MonHoc x : a) System.out.println(x);
    }
}
