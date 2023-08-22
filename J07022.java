import java.util.*;
import java.io.*;

public class J07022 {
    public static boolean res(String s){
        try{
            Integer.parseInt(s);
            return false;
        } catch (Exception e){
            return true;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            ArrayList<String> a=new ArrayList<>();
            while(sc.hasNext()){
                String s=sc.next();
                if (res(s)) a.add(s);
            }
            Collections.sort(a);
            for(String x:a) System.out.printf("%s ",x);
        } catch (Exception e) {
        }
    }
}
