import java.math.*;
import java.util.*;

public class J03013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int n=s.length();
            BigInteger a=new BigInteger(s);
            s=sc.next();
            n=Math.max(n,s.length());
            BigInteger b=new BigInteger(s);
            s=a.subtract(b).abs().toString();
            while(s.length()<n) s="0"+s;
            System.out.println(s);
        }
        sc.close();
    }
}
