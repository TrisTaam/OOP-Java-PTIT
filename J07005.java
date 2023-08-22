import java.util.*;
import java.io.*;

public class J07005 {
    public static void main(String[] args) {
        try {
            DataInputStream dt=new DataInputStream(new FileInputStream("DATA.IN"));
            HashMap<Integer,Integer> a=new HashMap<>();
            for(int i=0;i<100000;++i){
                int b=dt.readInt();
                if (a.containsKey(b)) a.put(b,a.get(b)+1);
                else a.put(b,1);
            }
            dt.close();
            for(Integer x:a.keySet()) System.out.printf("%d %d\n",x,a.get(x));
        } catch (Exception e) {
        }
    }
}
