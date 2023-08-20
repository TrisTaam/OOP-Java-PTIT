import java.util.*;

public class J02016 {
    public static boolean res(int n,long[] a){
        for(int i=1;i<n-1;++i){
            int l=0;
            int r=n-1;
            while(l<r){
                if (a[l]+a[r]<a[i]) l++;
                else if (a[l]+a[r]>a[i]) r--;
                else return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long[] a=new long[n];
            for(int i=0;i<n;++i){
                long x=sc.nextLong();
                a[i]=x*x;
            }
            Arrays.sort(a);
            System.out.println(res(n,a)?"YES":"NO");
        }
        sc.close();
    }
}
