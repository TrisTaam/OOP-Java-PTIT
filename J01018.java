import java.util.Scanner;

public class J01018 {
    public static boolean res(String s){
        int ans=0;
        for(int i=0;i<s.length()-1;++i){
            if (Math.abs(s.charAt(i)-s.charAt(i+1))!=2) return false;
            ans+=(s.charAt(i)-'0');
        }
        ans+=(s.charAt(s.length()-1)-'0');
        return ans%10==0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            String s=scanner.next();
            System.out.println(res(s)?"YES":"NO");
        }
        scanner.close();
    }
}
