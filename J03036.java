import java.util.*;

public class J03036 {
    public static String rotate(String s){
        return s.substring(1)+s.charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] a=new String[n];
        for(int i=0;i<n;++i) a[i]=sc.next();
        int m=a[0].length();
        int ans=(int)1e9;
        for(int i=0;i<n;++i){
            int cnt1=0;
            for(int j=0;j<n;++j){
                String tmp=a[j];
                int cnt2=0;
                while(!tmp.equals(a[i])&&cnt2<m){
                    tmp=rotate(tmp);
                    cnt2++;
                }
                if (!tmp.equals(a[i])){
                    ans=-1;
                    break;
                }
                cnt1+=cnt2;
            }
            if (ans==-1) break;
            ans=Math.min(ans,cnt1);
        }
        System.out.println(ans);
        sc.close();
    }
}
