import java.util.Scanner;

public class J02004 {
    public static boolean res(int n,int[] a){
        for(int i=0;i<=n/2;++i)
            if (a[i]!=a[n-i-1]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        int[] a=new int[100];
        while(t-->0){
            int n=scanner.nextInt();
            for(int i=0;i<n;++i) a[i]=scanner.nextInt();
            System.out.println(res(n,a)?"YES":"NO");
        }
        scanner.close();
    }
}
