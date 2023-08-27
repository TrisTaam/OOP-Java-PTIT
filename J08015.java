import java.util.*;

public class J08015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long k=sc.nextLong();
            TreeMap<Long,Long> a=new TreeMap<>();
            for(int i=0;i<n;++i){
                long x=sc.nextLong();
                if (a.containsKey(x)) a.put(x,a.get(x)+1);
                else a.put(x,1L);
            }
            long[] b=new long[a.size()];
            long[] c=new long[a.size()];
            int m=0;
            for(Long x:a.keySet()){
                b[m]=x;
                c[m]=a.get(x);
                m++;
            }
            long ans=0;
            for(int i=0;i<m;++i)
                if (b[i]*2==k) ans+=(c[i]-1)*c[i]/2;
            for(int i=0;i<m-1;++i){
                int j=Arrays.binarySearch(b,i+1,m,k-b[i]);
                if (j>=0) ans+=c[i]*c[j];
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
