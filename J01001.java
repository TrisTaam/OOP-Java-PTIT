import java.util.Scanner;

public class J01001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        if (a<=0||b<=0) System.out.println(0);
        else{
            System.out.printf("%d %d",(a+b)*2,a*b);
        }
        scanner.close();
    }
}