import java.math.*;
import java.util.*;

public class J03039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        BigInteger c=new BigInteger("0");
        while(t-->0){
            BigInteger a=new BigInteger(sc.next());
            BigInteger b=new BigInteger(sc.next());
            System.out.println((a.mod(b).equals(c)||b.mod(a).equals(c))?"YES":"NO");
        }
        sc.close();
    }
}
