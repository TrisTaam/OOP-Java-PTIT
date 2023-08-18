import java.util.Scanner;

public class J03032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String[] a=sc.nextLine().trim().split("\\s+");
            for(String x:a){
                for(int i=x.length()-1;i>=0;--i) System.out.print(x.charAt(i));
                System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
    }   
}
