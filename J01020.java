import java.util.*;

public class J01020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            if (n==0){
                System.out.println("Impossible");
                continue;
            }
            int i=1;
            boolean[] a=new boolean[10];
            while(true){
                long m=n*i;
                while(m>0){
                    a[(int)m%10]=true;
                    m/=10;
                }
                boolean kt=true;
                for(int j=0;j<10;++j)
                    if (!a[j]){
                        kt=false;
                        break;
                    }
                if (kt) break;
                i++;
            }
            System.out.println(n*i);
        }
        sc.close();
    }
}
