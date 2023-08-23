import java.io.*;
import java.util.*;

public class J07030 {
    public static boolean nto(int n){
        for(int i=2;i*i<=n;++i)
            if (n%i==0) return false;
        return n>1;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ot1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ot2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> a = (ArrayList<Integer>) ot1.readObject();
        List<Integer> b = (ArrayList<Integer>) ot2.readObject();
        ot1.close();
        ot2.close();
        TreeSet<Integer> c=new TreeSet<>();
        for(Integer x:a)
            if (nto(x)) c.add(x);
        TreeSet<Integer> d=new TreeSet<>();
        for(Integer x:b)
            if (nto(x)) d.add(x);
        for(Integer x:c)
            if (x<1000000-x)
                if (d.contains(1000000-x)) System.out.println(x+" "+(1000000-x));
    }
}