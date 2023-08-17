import java.util.Scanner;

public class J01021 {
    public static int du=(int)1e9+7;

    public static long pow(long a,long b){
        if (b==0) return 1;
        long c=pow(a,b/2);
        c=(c*c)%du;
        if (b%2==1) return (c*a)%du;
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            long a=scanner.nextLong();
            long b=scanner.nextLong();
            if (a==0&&b==0) break;
            System.out.println(pow(a,b));
        }
        scanner.close();
    }
}
