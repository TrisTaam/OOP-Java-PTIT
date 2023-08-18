import java.util.Scanner;

public class J03021 {
    public static char get(char x){
        if (x<='C') return '2';
        if (x<='F') return '3';
        if (x<='I') return '4';
        if (x<='L') return '5';
        if (x<='O') return '6';
        if (x<='S') return '7';
        if (x<='V') return '8';
        return '9';
    }

    public static boolean res(String s){
        for(int i=0;i<s.length();++i){
            char x=get(s.charAt(i));
            char y=get(s.charAt(s.length()-i-1));
            if (x!=y) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            System.out.println(res(sc.next().toUpperCase())?"YES":"NO");
        }
        sc.close();
    }
}
