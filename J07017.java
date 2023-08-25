import java.io.*;
import java.util.*;

class Pair<X extends Number, Y extends Number> {
    private X first;
    private Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return first;
    }

    public void setFirst(X first) {
        this.first = first;
    }

    public Y getSecond() {
        return second;
    }

    public void setSecond(Y second) {
        this.second = second;
    }

    private boolean nto(int x) {
        for (int i = 2; i * i <= x; ++i)
            if (x % i == 0) return false;
        return true;
    }

    public boolean isPrime() {
        return nto((Integer)this.first) && nto((Integer) this.second);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.first, this.second);
    }
}

public class J07017 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean check = false;
            for (int i = 2; i <= 2 * Math.sqrt(n); i++) {
                Pair<Integer, Integer> p = new Pair<>(i, n - i);
                if (p.isPrime()) {
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if (!check) System.out.println(-1);
        }
    }
}
