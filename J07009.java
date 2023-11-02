import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class IntSet {
    private TreeSet<Integer> set;

    public IntSet(int[] arr) {
        set = new TreeSet<>();
        for (int x : arr) set.add(x);
    }

    public IntSet() {
        set = new TreeSet<>();
    }

    public IntSet intersection(IntSet o) {
        try {
            IntSet a = new IntSet();
            for (Integer x : set)
                if (o.set.contains(x)) a.set.add(x);
            return a;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        for (Integer x : set) s += (x + " ");
        return s;
    }
}

public class J07009 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}