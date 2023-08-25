import java.io.*;
import java.util.*;

public class J07006 {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        ObjectInputStream ot=new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a=(ArrayList<Integer>) ot.readObject();
        int[] b=new int[1000];
        for(Integer x:a) b[x]++;
        for(int i=0;i<1000;++i)
            if (b[i]>0) System.out.println(i+" "+b[i]);
        ot.close();
    }
}