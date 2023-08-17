import java.util.Scanner;

public class J01006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        long[] a=new long[100];
        a[1]=1;
        a[2]=1;
        for(int i=3;i<=92;++i) a[i]=a[i-1]+a[i-2];
        while(t-->0){
            int n=scanner.nextInt();
            System.out.println(a[n]);
        }
        scanner.close();
    }
}
