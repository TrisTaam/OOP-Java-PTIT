import java.math.BigInteger;
import java.util.Scanner;

public class J01011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            BigInteger a=BigInteger.valueOf(scanner.nextLong());
            BigInteger b=BigInteger.valueOf(scanner.nextLong());
            BigInteger c=a.gcd(b);
            BigInteger d=a.multiply(b).divide(c);
            System.out.println(d+" "+c);
        }
        scanner.close();
    }
}
