import java.util.ArrayList;
import java.util.Scanner;

class Matrix {
    private ArrayList<ArrayList<Long>> matrix = new ArrayList<>();
    private int n;
    private int m;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public void nextMatrix(Scanner sc) {
        for (int i = 0; i < this.n; ++i) {
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < this.m; ++j) tmp.add(sc.nextLong());
            this.matrix.add(tmp);
        }
    }

    public Matrix trans() {
        Matrix c = new Matrix(this.m, this.n);
        for (int i = 0; i < this.m; ++i) {
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < this.n; ++j) tmp.add(this.matrix.get(j).get(i));
            c.matrix.add(tmp);
        }
        return c;
    }

    public Matrix mul(Matrix o) {
        Matrix c = new Matrix(this.n, o.m);
        for (int i = 0; i < this.n; ++i) {
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < o.m; ++j) {
                long sum = 0;
                for (int z = 0; z < this.m; ++z) sum += this.matrix.get(i).get(z) * o.matrix.get(z).get(j);
                tmp.add(sum);
            }
            c.matrix.add(tmp);
        }
        return c;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.m; ++j) s.append(this.matrix.get(i).get(j).toString()).append(" ");
            s.append("\n");
        }
        return s.toString();
    }
}

public class J04017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            Matrix a = new Matrix(n, m);
            a.nextMatrix(sc);
            Matrix b = a.trans();
            System.out.println(a.mul(b));
        }
    }
}