import java.util.*;

public class J03020 {
    public static boolean res(String s){
        for(int i=0;i<s.length()/2;++i)
            if (s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> a=new LinkedHashMap<>();
        while(sc.hasNextLine()){
            String[] b=sc.nextLine().split("\\s+");
            for(String x:b)
                if (res(x)){
                    if (a.containsKey(x)) a.put(x,a.get(x)+1);
                    else a.put(x,1);
                }
            }
        int cnt=0;
        for(String x:a.keySet()) cnt=Math.max(cnt,x.length());
        for(String x:a.keySet())
            if (cnt==x.length()) System.out.printf("%s %d\n",x,a.get(x));
        sc.close();
    }
}
