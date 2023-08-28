import java.util.*;

class IntSet {
    private TreeSet<Integer> a;

    public IntSet(int[] a) {
        this.a = new TreeSet<>();
        for (int i : a) this.a.add(i);
    }

    public IntSet(TreeSet<Integer> a) {
        this.a = a;
    }

    public IntSet union(IntSet x) {
        TreeSet<Integer> y = new TreeSet<>();
        y.addAll(this.a);
        y.addAll(x.a);
        return new IntSet(y);
    }

    @Override
    public String toString() {
        String s = "";
        for (Integer i : this.a) s += (i.toString() + " ");
        return s;
    }
}

public class J04021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
