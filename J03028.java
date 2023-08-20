import java.util.*;

public class J03028 {
    public static int getInt(char x){
        return x-'A';
    }

    public static char getChar(int x){
        return (char)(x+'A');
    }

    public static String rotate(String s){
        int cnt=0;
        for(int i=0;i<s.length();++i) cnt+=getInt(s.charAt(i));
        String ans="";
        for(int i=0;i<s.length();++i) ans+=getChar((getInt(s.charAt(i))+cnt)%26);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            String a=rotate(s.substring(0,s.length()/2));
            String b=rotate(s.substring(s.length()/2));
            String ans="";
            for(int i=0;i<a.length();++i) ans+=getChar((getInt(a.charAt(i))+getInt(b.charAt(i)))%26);
            System.out.println(ans);
        }
        sc.close();
    }
}