import java.util.Scanner;

public class J03006 {
    public static boolean res(String s){
        for(int i=0;i<s.length()/2;++i){
            char x=s.charAt(i);
            char y=s.charAt(s.length()-i-1);
            if (x%2==1||y%2==1||x!=y) return false;
        }
        return true;
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
