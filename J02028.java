import java.util.*;

public class J02028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long k=sc.nextLong();
            long[] a=new long[n];
            for(int i=0;i<n;++i) a[i]=sc.nextLong();
            long s=0;
            int l=0;
            boolean kt=false;
            for(int i=0;i<n;++i){
                s+=a[i];
                while(s>k&&l<i) s-=a[l++];
                if (s==k){
                    kt=true;
                    break;
                }
            }
            System.out.println(kt?"YES":"NO");
        }
        sc.close();
    }
}