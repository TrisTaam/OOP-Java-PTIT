import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class J07085 {
    public static boolean res(int n){
        String s=Integer.toString(n);
        if (s.length()%2==0||s.length()==1) return false;
        for(int i=0;i<=s.length()/2;++i){
            char x=s.charAt(i);
            char y=s.charAt(s.length()-i-1);
            if ((x-'0')%2==0||(y-'0')%2==0||x!=y) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ot = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) ot.readObject();
        ot.close();
        for(String x:a){
            String s="";
            int cnt=0;
            for(int i=0;i<x.length();++i)
                if (x.charAt(i)>='0'&&x.charAt(i)<='9'){
                    s+=x.charAt(i);
                    cnt+=(x.charAt(i)-'0');
                }
            BigInteger b=new BigInteger(s);
            System.out.printf("%s %d\n",b,cnt);
        }
    }
}