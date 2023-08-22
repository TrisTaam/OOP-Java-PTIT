import java.util.*;
import java.io.*;

public class J07004 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            HashMap<Integer,Integer> a=new HashMap<>();
            while(sc.hasNextInt()){
                int b=sc.nextInt();
                if (a.containsKey(b)) a.put(b,a.get(b)+1);
                else a.put(b,1);
            }
            for(Integer x:a.keySet()) System.out.printf("%d %d\n",x,a.get(x));
        } catch (Exception e) {
        }
    }
}
