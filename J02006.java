import java.util.*;

public class J02006 {
    public static final int A=1005;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean[] a = new boolean[A];
        for(int i=0;i<n;++i) a[sc.nextInt()]=true;
        for(int i=0;i<m;++i) a[sc.nextInt()]=true;
        for(int i=1;i<=1000;++i)
            if (a[i]) System.out.print(i+" ");
        sc.close();
    }
}
