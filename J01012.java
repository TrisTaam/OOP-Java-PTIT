import java.util.Scanner;

public class J01012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n=scanner.nextInt();
            int cnt=0;
            for(int i=1;i*i<=n;++i)
                if (n%i==0){
                    cnt+=(i%2==0?1:0);
                    if (i!=n/i) cnt+=((n/i)%2==0?1:0);
                }
            System.out.println(cnt);
        }
        scanner.close();
    }
}
