import java.io.*;
import java.util.*;

public class J07015 {
    public static int[] b = new int[10000];

    public static void sieve() {
        Arrays.fill(b, 1);
        b[0] = b[1] = 0;
        for (int i = 2; i <= 100; i++)
            if (b[i] == 1)
                for (int j = i * i; j < 10000; j += i)
                    b[j] = 0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ot = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        List<Integer> a = (List<Integer>) ot.readObject();
        int[] c = new int[10000];
        for (Integer i : a)
            c[i] += b[i];
        for (int i = 2; i < 10000; i++)
            if (c[i] > 0)
                System.out.println(i + " " + c[i]);
        ot.close();
    }
}