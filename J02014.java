import java.util.Scanner;

public class J02014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n+1];
            a[0]=0;
            for(int i=1;i<=n;++i) a[i]=a[i-1]+sc.nextInt();
            int ans=-1;
            for(int i=2;i<n;++i)
                if (a[i-1]==a[n]-a[i]){
                    ans=i;
                    break;
                }
            System.out.println(ans);
        }
        sc.close();
    }
}
