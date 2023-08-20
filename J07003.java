import java.io.File;
import java.math.BigInteger;
import java.util.*;

public class J07003 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("DATA.in"));
            String s=sc.next();
            while (s.length()>1){
                BigInteger a=new BigInteger(s.substring(0,s.length()/2));
                BigInteger b=new BigInteger(s.substring(s.length()/2));
                s=a.add(b).toString();
                System.out.println(s);
            }
        } catch(Exception e){

        }
    }
}
