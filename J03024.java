import java.util.Scanner;

public class J03024 {
    public static String res(String s){
        if (s.charAt(0)=='0') return "INVALID";
        int odd=0;
        int even=0;
        for(int i=0;i<s.length();++i){
            char x=s.charAt(i);
            if (x<'0'||x>'9') return "INVALID";
            if ((x-'0')%2==0) even++;
            else odd++;
        }
        if (odd==even) return "NO";
        return (s.length()%2+((odd>even)?1:0))%2==0?"YES":"NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            System.out.println(res(sc.next()));
        }
        sc.close();
    }
}
