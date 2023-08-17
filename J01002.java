import java.util.Scanner;

public class J01002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            long a=scanner.nextLong();
            System.out.println(a*(a+1)/2);
        }
        scanner.close();
    }
}
