import java.util.*;

public class J08024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Queue<Long> q=new LinkedList<>();
            q.offer(9L);
            while(true){
                long x=q.remove();
                if (x%n==0){
                    System.out.println(x);
                    break;
                }
                q.offer(x*10);
                q.offer(x*10+9);
            }
        }
        sc.close();
    }
}
