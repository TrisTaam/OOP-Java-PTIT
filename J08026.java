import java.util.*;

class Pair{
    public int first;
    public int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

public class J08026 {
    public static int bfs(int a,int b){
        Queue<Pair> q=new LinkedList<>();
        TreeSet<Integer> c=new TreeSet<>();
        q.offer(new Pair(a,0));
        c.add(a);
        while(!q.isEmpty()){
            Pair x=q.remove();
            if (x.first==b) return x.second;
            if (x.first<b&&!c.contains(x.first*2)){
                q.offer(new Pair(x.first*2,x.second+1));
                c.add(x.first*2);
            }
            if (x.first>1&&!c.contains(x.first-1)){
                q.offer(new Pair(x.first-1,x.second+1));
                c.add(x.first-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(bfs(a,b));
        }
        sc.close();
    }
}
