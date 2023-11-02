import java.util.*;

public class J03035 {
    public static long[] x=new long[11];

    public static long res(String a,String b){
        int cnt1=0;
        for(int i=0;i<a.length();++i)
            if (a.charAt(i)=='?') cnt1++;
        int cnt2=0;
        for(int i=0;i<a.length();++i)
            if (a.charAt(i)!='?'){
                if (a.charAt(i)<b.charAt(i)) return 0;
                else if (a.charAt(i)>b.charAt(i)) return x[cnt1-cnt2];
            }
            else{
                cnt2++;
                return ('9'-b.charAt(i))*x[cnt1-cnt2]+res(a.substring(0,i)+b.charAt(i)+a.substring(i+1),b);
            }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        x[0]=1;
        for(int i=1;i<=10;++i) x[i]=x[i-1]*10;
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            System.out.println(res(a,b));
        }
        sc.close();
    }
}
