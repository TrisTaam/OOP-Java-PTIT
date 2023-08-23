import java.util.*;

public class J02027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            Arrays.sort(a);
            int l=0;
            long ans=0;
            for(int i=1;i<n;++i){
                while(l<i&&a[l]+k<=a[i]) l++;
                ans+=(i-l);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
