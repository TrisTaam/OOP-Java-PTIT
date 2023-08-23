import java.util.*;

public class J02019 {
    public static final int N=(int)1e6+5;
    public static int[] a=new int[N];

    public static void sieve(){
        for(int i=1;i<=N-5;++i)
            for(int j=i*2;j<=N-5;j+=i) a[j]+=i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sieve();
        int l=sc.nextInt();
        int r=sc.nextInt();
        int ans=0;
        for(int i=l;i<=r;++i)
            if (a[i]>i) ans++;
        System.out.println(ans);
        sc.close();
    }
}
