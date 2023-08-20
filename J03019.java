import java.util.*;

public class J03019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        String ans="";
        int i=0;
        while (i<s.length()){
            char a=s.charAt(i);
            int b=i;
            for(int j=i+1;j<s.length();++j)
                if (a<s.charAt(j)){
                    a=s.charAt(j);
                    b=j;
                }
            for(int j=i;j<s.length();++j)
                if (a==s.charAt(j)){
                    ans+=a;
                    b=j;
                }
            i=b+1;
        }
        System.out.println(ans);
        sc.close();
    }
}
