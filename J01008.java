import java.util.Scanner;

public class J01008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=1;i<=t;++i){
            int n=scanner.nextInt();
            System.out.print("Test "+i+": ");
            for(int j=2;j*j<=n;++j){
                int cnt=0;
                while(n%j==0){
                    cnt++;
                    n/=j;
                }
                if (cnt>0) System.out.print(j+"("+cnt+") ");
            }
            if (n>1) System.out.print(n+"(1)");
            System.out.println();
        }
        scanner.close();
    }
}
