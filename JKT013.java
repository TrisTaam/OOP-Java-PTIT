import java.util.*;

public class JKT013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Queue<String> q=new LinkedList<>();
            q.offer("6");
            q.offer("8");
            ArrayList<String> a=new ArrayList<>();
            while(true){
                String s=q.poll();
                if (s.length()>n) break;
                a.add(s);
                q.offer(s+"6");
                q.offer(s+"8");
            }
            System.out.println(a.size());
            for(int i=a.size()-1;i>=0;--i) System.out.printf("%s ",a.get(i));
            System.out.println();
        }
        sc.close();
    }
}
