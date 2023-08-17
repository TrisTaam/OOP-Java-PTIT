import java.util.*;

public class J02020 {
    public static int cnt=0;

    public static void Try(int i,int j,int n,int k,String s){
        for(int z=j;z<=n;++z)
            if (i==k){
                cnt++;
                System.out.println(s+Integer.toString(z)+" ");
            }
            else Try(i+1,z+1,n,k,s+Integer.toString(z)+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        Try(1,1,n,k,"");
        System.out.println("Tong cong co "+cnt+" to hop");
        sc.close();
    }
}
