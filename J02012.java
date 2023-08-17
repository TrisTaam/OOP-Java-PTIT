import java.util.*;

public class J02012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;++i) a[i]=sc.nextInt();
        int[] b=new int[n];
        for(int i=0;i<n;++i){
            System.out.print("Buoc "+i+": ");
            int j=0;
            while(j<i&&a[i]>=b[j]) j++;
            for(int z=i;z>j;--z) b[z]=b[z-1];
            b[j]=a[i];
            for(j=0;j<=i;++j) System.out.print(b[j]+" ");
            System.out.println();
        }
        sc.close();
    }
}
