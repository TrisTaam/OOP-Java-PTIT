import java.util.*;

public class J03031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int k=sc.nextInt();
            int[] a=new int[26];
            for(int i=0;i<s.length();++i) a[s.charAt(i)-'a']++;
            int cnt1=0;
            int cnt2=0;
            for(int i=0;i<26;++i)
                if (a[i]>1) cnt1+=(a[i]-1);
                else if (a[i]==0) cnt2++;
            System.out.println(cnt1>=cnt2&&cnt2<=k?"YES":"NO");
        }
        sc.close();
    }
}
