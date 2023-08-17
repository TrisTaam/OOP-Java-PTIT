import java.util.*;

public class J02008 {
    public static long gcd(long a,long b){
        while(b>0){
            long r=a%b;
            a=b;
            b=r;
        }
        return a;
    }

    public static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            long ans=1;
            for(long i=1L;i<=n;++i) ans=lcm(ans,i);
            System.out.println(ans);
        }
        sc.close();
    }
}
