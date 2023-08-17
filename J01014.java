import java.util.Scanner;

public class J01014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        long ans=0;
        while(t-->0){
            long n=scanner.nextLong();
            for(long i=2;i*i<=n;++i)
                if (n%i==0){
                    ans=i;
                    while(n%i==0) n/=i;
                }
            if (n>1) ans=n;
            System.out.println(ans);
        }
        scanner.close();
    }
}
