import java.io.*;
import java.util.*;

public class J07076 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt() - 1;
            int[][] a = new int[n][m];
            int[] b = new int[n];
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j) {
                    a[i][j] = sc.nextInt();
                    if (j == k) b[i] = a[i][j];
                }
            Arrays.sort(b);
            for (int i = 0; i < n; ++i) a[i][k] = b[i];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) System.out.printf("%d ", a[i][j]);
                System.out.println();
            }
        }
    }
}
