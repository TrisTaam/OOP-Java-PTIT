import java.util.*;

public class J02037 {
    public static boolean res(String[] a){
        int odd=0;
        int even=0;
        for(String x:a)
            if ((x.charAt(x.length()-1)-'0')%2==1) odd++;
            else even++;
        return ((a.length&1)+(odd>even?1:0))%2==0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String[] a=sc.nextLine().split("\\s+");
            System.out.println(res(a)?"YES":"NO");
        }
        sc.close();
    }
}
