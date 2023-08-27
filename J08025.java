import java.util.*;

class Pair{
    public String first;
    public Integer second;

    Pair(String first,Integer second){
        this.first=first;
        this.second=second;
    }
}

public class J08025 {
    public static int[] l={3,0,2,4,1,5};
    public static int[] r={0,4,1,3,5,2};

    public static String left(String s){
        String ans="";
        for(int i=0;i<6;++i) ans+=s.charAt(l[i]);
        return ans;
    }

    public static String right(String s){
        String ans="";
        for(int i=0;i<6;++i) ans+=s.charAt(r[i]);
        return ans;
    }

    public static int bfs(String a,String b){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(a,0));
        HashSet<String> c=new HashSet<>();
        c.add(a);
        while(!q.isEmpty()){
            Pair x=q.remove();
            if (x.first.equals(b)) return x.second;
            String y=left(x.first);
            if (!c.contains(y)){
                q.offer(new Pair(y,x.second+1));
                c.add(y);
            }
            y=right(x.first);
            if (!c.contains(y)){
                q.offer(new Pair(y,x.second+1));
                c.add(y);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a="";
            for(int i=0;i<6;++i) a+=Integer.toString(sc.nextInt());
            String b="";
            for(int i=0;i<6;++i) b+=Integer.toString(sc.nextInt());
            System.out.println(bfs(a,b));
        }
        sc.close();
    }
}
