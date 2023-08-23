import java.io.*;
import java.util.*;

public class J07032 {
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
        ObjectInputStream ot1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ot2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        List<Integer> a = (ArrayList<Integer>) ot1.readObject();
        List<Integer> b = (ArrayList<Integer>) ot2.readObject();
        ot1.close();
        ot2.close();
        int[] c=new int[1000001];
        for(Integer x:a)
            if (res(x)) c[x]++;
        int[] d=new int[1000001];
        for(Integer x:b)
            if (res(x)) d[x]++;
        int cnt=0;
        for(int i=0;i<=1000000;++i)
            if (c[i]>0&&d[i]>0){
                System.out.println(i+" "+(c[i]+d[i]));
                cnt++;
                if (cnt==10) break;
            }
    }
}