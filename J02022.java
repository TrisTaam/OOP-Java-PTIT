import java.util.*;

public class J02022 {
    private static boolean[] a=new boolean[15];

    public static void Try(int i,int j,int n,String s){
        for(int z=1;z<=n;++z)
            if (Math.abs(z-j)>1&&!a[z]){
                a[z]=true;
                if (i==n) System.out.println(s+Integer.toString(z));
                else Try(i+1,z,n,s+Integer.toString(z));
                a[z]=false;
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Arrays.fill(a,false);
            Try(1,-1,n,"");
        }
        sc.close();
    }
}
