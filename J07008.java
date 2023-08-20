import java.util.*;
import java.io.*;

public class J07008 {
    public static int n;
    public static int[] a=new int[25];
    public static ArrayList<String> b=new ArrayList<>();

    public static void Try(int i,int j,String s){
        for(int z=j;z<=n;++z)
            if (a[z]>a[j-1])
                if (i<=n){
                    if (i>1){
                        b.add(s+Integer.toString(a[z])+" ");
                    }
                    Try(i+1,z+1,s+Integer.toString(a[z])+" ");
                }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        n=sc.nextInt();
        a[0]=0;
        for(int i=1;i<=n;++i) a[i]=sc.nextInt();
        Try(1,1,"");
        Collections.sort(b);
        for(String x:b) System.out.println(x);
    }
}
