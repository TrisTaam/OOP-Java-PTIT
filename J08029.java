import java.util.*;

class Triple{
    public int first;
    public int second;
    public int third;

    Triple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

public class J08029 {
    public static int[] dx={-2,-1,1,2,2,1,-1,-2};
    public static int[] dy={1,2,2,1,-1,-2,-2,-1};

    public static int bfs(int a,int b,int c,int d){
        Queue<Triple> q=new LinkedList<>();
        q.offer(new Triple(a,b,0));
        boolean[][] e=new boolean[9][9];
        e[a][b]=true;
        while(!q.isEmpty()){
            Triple x=q.remove();
            if (x.first==c&&x.second==d) return x.third;
            for(int i=0;i<8;++i){
                int u=x.first+dx[i];
                int v=x.second+dy[i];
                if (u>=1&&u<=8&&v>=1&&v<=8&&!e[u][v]){
                    q.offer(new Triple(u,v,x.third+1));
                    e[u][v]=true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        String s;
        while(t-->0){
            s=sc.next();
            int a=s.charAt(0)-'a'+1;
            int b=s.charAt(1)-'0';
            s=sc.next();
            int c=s.charAt(0)-'a'+1;
            int d=s.charAt(1)-'0';
            System.out.println(bfs(a,b,c,d));
        }
        sc.close();
    }
}
