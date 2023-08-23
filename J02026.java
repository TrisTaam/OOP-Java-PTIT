import java.util.*;

public class J02026 {
    public static void Try(int i,int j,int[] a,int n,int k,String s){
        for(int z=j;z<n;++z){
            if (i==k) System.out.println(s+Integer.toString(a[z]));
            else Try(i+1,z+1,a,n,k,s+Integer.toString(a[z])+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            Arrays.sort(a);
            Try(1,0,a,n,k,"");
        }
        sc.close();
    }
}
