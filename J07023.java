import java.io.*;
import java.util.*;

public class J07023 {
    public static int[] b = new int[10000];

    public static void sieve() {
        Arrays.fill(b, 1);
        b[0] = b[1] = 0;
        for (int i = 2; i <= 100; i++)
            if (b[i] == 1)
                for (int j = i * i; j < 10000; j += i)
                    b[j] = 0;
    }

    public static boolean palin(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i < s.length() / 2; ++i)
            if (s.charAt(i) != s.charAt(s.length() - i -1)) return false;
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ot1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ot2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) ot1.readObject();
        ArrayList<Integer> a2 = (ArrayList<Integer>) ot2.readObject();
        int[] c = new int[10000];
        for (Integer i : a1)
            if (palin(i)) c[i] += b[i];
        int[] d = new int[10000];
        for (Integer i : a2)
            if (palin(i)) d[i] += b[i];
        for (int i = 2; i < 10000; i++)
            if (c[i] > 0 && d[i] > 0)
                System.out.println(i + " " + c[i] + " " + d[i]);
        ot1.close();
        ot2.close();
    }
}