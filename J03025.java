import java.util.Scanner;

public class J03025 {
    public static boolean res(String s){
        int cnt=0;
        for(int i=0;i<s.length()/2;++i)
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) cnt++;
        if (cnt<=1&&s.length()%2==1) return true;
        if (cnt==1&&s.length()%2==0) return true;
        return false;
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
