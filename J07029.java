import java.io.*;
import java.util.*;

public class J07029 {
    public static int[] b=new int[1000001];

    public static void sieve() {
        Arrays.fill(b,1);
        b[0]=b[1]=0;
        for(int i=2;i*i<=1000000;++i)
            if (b[i]==1)
                for(int j=i*i;j<=1000000;j+=i) b[j]=0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ot = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> a = (ArrayList<Integer>) ot.readObject();
        int[] c = new int[1000001];
        for(Integer x:a) c[x]+=b[x];
        int cnt=0;
        for(int i=1000000;i>=2;--i)
            if (c[i]>0){
                System.out.println(i+" "+c[i]);
                cnt++;
                if (cnt==10) break;
            }
        ot.close();
    }
}