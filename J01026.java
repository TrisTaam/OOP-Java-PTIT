import java.util.Scanner;

public class J01026 {
    public static boolean res(int n){
        int a=(int)Math.sqrt(n);
        return a*a==n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n=scanner.nextInt();
            System.out.println(res(n)?"YES":"NO");
        }
        scanner.close();
    }
}
