import java.util.Scanner;

public class J01009 {
    static long[] a=new long[25];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        long tmp=1,ans=0;
        for(int i=1;i<=n;++i){
            tmp*=i;
            ans+=tmp;
        }
        System.out.println(ans);
        scanner.close();
    }
}
