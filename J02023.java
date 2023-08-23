import java.util.*;

public class J02023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        if (n==1&&s==0) System.out.println("0 0");
        else if (9*n<s||s==0) System.out.println("-1 -1");
        else{
            int s1=s;
            int[] a=new int[n];
            for(int i=n-1;i>=0;--i){
                for(int j=9;j>=0;--j)
                    if (s1-j>=0){
                        a[i]=j;
                        s1-=j;
                        break;
                    }
                if (a[i]==0) break;
            }
            if (a[0]==0){
                a[0]=1;
                for(int i=1;i<n;++i)
                    if (a[i]>0){
                        a[i]--;
                        break;
                    }
            }
            for(int i=0;i<n;++i){
                System.out.print(a[i]);
                a[i]=0;
            }
            System.out.print(" ");
            s1=s;
            for(int i=0;i<n;++i){
                for(int j=9;j>=0;--j)
                    if (s1-j>=0){
                        a[i]=j;
                        s1-=j;
                        break;
                    }
                if (a[i]==0) break;
            }
            for(int i=0;i<n;++i) System.out.print(a[i]);
        }
        sc.close();
    }
}
