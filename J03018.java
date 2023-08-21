import java.util.*;

public class J03018 {
    public static int[] a={1,2,4,3};
    public static int[] b={1,3,4,2};
    public static int[] c={1,4};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int n;
            if (s.length()<=2) n=Integer.parseInt(s);
            else n=Integer.parseInt(s.substring(s.length()-2));
            System.out.println((1+a[n%4]+b[n%4]+c[n%2])%5);
        }
        sc.close();
    }
}
