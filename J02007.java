import java.util.*;

public class J02007 {
    public static final int A=(int)1e5+5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;++i){
            System.out.println("Test "+i+":");
            int n=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[A];
            for(int j=0;j<n;++j){
                a[j]=sc.nextInt();
                b[a[j]]++;
            }
            for(int j=0;j<n;++j)
                if (b[a[j]]>0){
                    System.out.println(a[j]+" xuat hien "+b[a[j]]+" lan");
                    b[a[j]]=0;
                }
        }
        sc.close();
    }
}
