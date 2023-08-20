import java.util.*;

public class J03023 {
    public static int get(char x){
        if (x=='I') return 1;
        if (x=='V') return 5;
        if (x=='X') return 10;
        if (x=='L') return 50;
        if (x=='C') return 100;
        if (x=='D') return 500;
        return 1000;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int ans=0;
            for(int i=0;i<s.length();++i){
                if (i<s.length()-1){
                    char a=s.charAt(i);
                    char b=s.charAt(i+1);
                    i++;
                    if (a=='I'&&b=='V') ans+=4;
                    else if (a=='I'&&b=='X') ans+=9;
                    else if (a=='X'&&b=='L') ans+=40;
                    else if (a=='X'&&b=='C') ans+=90;
                    else if (a=='C'&&b=='D') ans+=400;
                    else if (a=='C'&&b=='M') ans+=900;
                    else{
                        ans+=get(a);
                        i--;
                    }
                }
                else ans+=get(s.charAt(i));
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
