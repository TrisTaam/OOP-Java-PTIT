import java.util.*;

public class JKT014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Stack<Integer> b=new Stack<>();
            int[] a=new int[n+1];
            a[0]=(int)1e9;
            for(int i=1;i<=n;++i) a[i]=sc.nextInt();
            b.push(0);
            for(int i=1;i<=n;++i){
                while(!b.isEmpty()&&a[b.peek()]<=a[i]) b.pop();
                System.out.printf("%d ",i-b.peek());
                b.push(i);
            }
            System.out.println();
        }
        sc.close();
    }
}
