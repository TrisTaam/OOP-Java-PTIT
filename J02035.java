import java.util.*;

public class J02035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long[] a=new long[n];
            for(int i=0;i<n;++i) a[i]=sc.nextLong();
            int cnt=1;
            for(int i=0;i<n-1;++i)
                if (a[i]<a[i+1]) cnt++;
                else break;
            System.out.println(cnt==n?0:cnt);
        }
        sc.close();
    }
}