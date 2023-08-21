import java.util.*;

public class J03037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int[] a=new int[26];
        Arrays.fill(a,-1);
        int[] b=new int[26];
        for(int i=0;i<s.length();++i)
            if (a[s.charAt(i)-'A']==-1) a[s.charAt(i)-'A']=i;
            else b[s.charAt(i)-'A']=i;
        int ans=0;
        for(int i=0;i<26;++i)
            for(int j=0;j<26;++j)
                if (a[i]<a[j]&&a[j]<b[i]&&b[i]<b[j]) ans++;
        System.out.println(ans);
        sc.close();
    }
}
