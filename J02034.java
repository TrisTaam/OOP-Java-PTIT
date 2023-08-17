import java.util.*;

public class J02034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a=1;
        boolean[] b=new boolean[205];
        for(int i=0;i<n;++i){
            a=sc.nextInt();
            b[a]=true;
        }
        boolean kt=true;
        for(int i=1;i<=a;++i)
            if (!b[i]){
                kt=false;
                System.out.println(i);
            }
        if (kt) System.out.println("Excellent!");
        sc.close();
    }
}
