import java.util.*;

public class J03040 {
    public static boolean res(String s){
        String a=s.substring(5,8)+s.substring(9);
        int cnt=0;
        for(int i=0;i<a.length()-1;++i)
            if (a.charAt(i)==a.charAt(i+1)) cnt++;
        if (cnt==4) return true;
        if (a.charAt(0)==a.charAt(1)&&a.charAt(1)==a.charAt(2)&&a.charAt(3)==a.charAt(4)) return true;
        boolean kt=true;
        for(int i=0;i<a.length();++i)
            if (a.charAt(i)!='6'&&a.charAt(i)!='8'){
                kt=false;
                break;
            }
        if (kt) return true;
        for(int i=0;i<a.length()-1;++i)
            if (a.charAt(i)>=a.charAt(i+1)) return false;
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
