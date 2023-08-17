import java.util.*;

public class J02013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;++i) a[i]=sc.nextInt();
        for(int i=n-1;i>=0;--i){
            int cnt=0;
            for(int j=0;j<i;++j){
                if (a[j]>a[j+1]){
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
                else cnt++;
            }
            if (cnt==i) break;
            System.out.print("Buoc "+(n-i)+": ");
            for(int j=0;j<n;++j) System.out.print(a[j]+" ");
            System.out.println();
        }
        sc.close();
    }
}
