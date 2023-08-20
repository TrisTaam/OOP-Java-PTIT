import java.math.BigInteger;
import java.util.*;

public class J03016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        BigInteger b=new BigInteger("11");
        BigInteger c=new BigInteger("0");
        while(t-->0){
            BigInteger a=new BigInteger(sc.next());
            System.out.println(a.mod(b).equals(c)?1:0);
        }
        sc.close();
    }
}
