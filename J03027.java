import java.util.*;

public class J03027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder a=new StringBuilder(sc.next());
        String s="";
        while(true){
            boolean kt=false;
            s=a.toString();
            for(int i=0;i<s.length()-1;++i)
                if (s.charAt(i)==s.charAt(i+1)){
                    kt=true;
                    a.delete(i,i+2);
                    break;
                }
            if (!kt) break;
        }
        s=a.toString();
        System.out.println(s.isEmpty()?"Empty String":s);
        sc.close();
    }
}
