import java.util.Scanner;

public class J01005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n=scanner.nextInt();
            double h=scanner.nextDouble();
            for(int i=1;i<n;++i){
                System.out.printf("%.6f ",h*Math.sqrt(i)/Math.sqrt(n));
            }
            System.out.println();
        }
        scanner.close();
    }
}
