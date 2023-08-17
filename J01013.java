import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class J01013 {
    public static int N=2000005;
    public static ArrayList<Long> a=new ArrayList<>();

    public static void sieve(){
        boolean b[]=new boolean[N];
        Arrays.fill(b,true);
        b[0]=false;
        b[1]=false;
        for(int i=2;i*i<=N-5;++i)
            if (b[i])
                for(int j=i*i;j<=N-5;j+=i) b[j]=false;
        for(int i=2;i<b.length;++i)
            if (b[i]) a.add((long)i);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sieve();
        long ans=0;
        int t=scanner.nextInt();
        while(t-->0){
            long n=scanner.nextLong();
            for(int i=0;a.get(i)*a.get(i)<=n;++i)
                while(n%a.get(i)==0){
                    ans+=a.get(i);
                    n/=a.get(i);
                }
            if (n>1) ans+=n;
        }
        System.out.println(ans);
        scanner.close();
    }
}
