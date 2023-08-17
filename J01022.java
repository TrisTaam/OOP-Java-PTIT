import java.util.Scanner;

public class J01022 {
    public static long[] a=new long[100];

    public static char res(int n,long k){
        if (n==1) return '0';
        if (n==2) return '1';
        if (k<=a[n-2]) return res(n-2,k);
        return res(n-1,k-a[n-2]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        a[1]=1;
        a[2]=1;
        for(int i=3;i<=92;++i) a[i]=a[i-1]+a[i-2];
        while(t-->0){
            int n=scanner.nextInt();
            long k=scanner.nextLong();
            System.out.println(res(n,k));
        }
        scanner.close();
    }
}
