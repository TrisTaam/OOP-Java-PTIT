import java.util.*;

public class J08011 {
    public static boolean res(String s){
        for(int i=0;i<s.length()-1;++i)
            if (s.charAt(i)>s.charAt(i+1)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> a=new LinkedHashMap<>();
        while(sc.hasNext()){
            String s=sc.next();
            if (res(s)){
                if (a.containsKey(s)) a.put(s,a.get(s)+1);
                else a.put(s,1);
            }
        }
        ArrayList<Map.Entry<String,Integer>> b=new ArrayList<>(a.entrySet());
        Comparator<Map.Entry<String,Integer>> c=new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
                return -o1.getValue().compareTo(o2.getValue());
            }
        };
        b.sort(c);
        for(Map.Entry<String,Integer> x:b) System.out.printf("%s %d\n",x.getKey(),x.getValue());
        sc.close();
    }
}
