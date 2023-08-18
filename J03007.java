import java.util.Scanner;

public class J03007 {
    public static boolean res(String s){
        if (s.charAt(0)!='8') return false;
        if (s.charAt(s.length()-1)!='8') return false;
        int ans=0;
        for(int i=0;i<s.length()/2;++i){
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
            ans+=(s.charAt(i)-'0');
            if (i!=s.length()-i-1) ans+=(s.charAt(s.length()-i-1)-'0');
        }
        return ans%10==0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            System.out.println(res(sc.next())?"YES":"NO");
        }
        sc.close();
    }
}
