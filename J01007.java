import java.util.Scanner;

public class J01007 {
    static long[] a=new long[100];

    public static boolean res(long n){
        for(int i=0;i<=92;++i)
            if (a[i]==n) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a[0]=0;
        a[1]=1;
        for(int i=2;i<=92;++i) a[i]=a[i-1]+a[i-2];
        int t=scanner.nextInt();
        while(t-->0){
            long n=scanner.nextLong();
            System.out.println(res(n)?"YES":"NO");
        }
        scanner.close();
    }
}
