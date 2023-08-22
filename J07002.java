import java.util.*;
import java.io.*;

public class J07002 {
    public static int res(String s){
        try{
            return Integer.parseInt(s);
        } catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            long ans=0;
            while(sc.hasNext()) ans+=res(sc.next());
            System.out.println(ans);
        } catch (Exception e) {
        }
    }
}
