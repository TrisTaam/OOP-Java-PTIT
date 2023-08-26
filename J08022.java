import java.util.*;

public class J08022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;++i) a[i]=sc.nextInt();
            Stack<Integer> b=new Stack<>();
            int[] c=new int[n];
            for(int i=n-1;i>=0;--i){
                while(!b.isEmpty()&&a[i]>=b.peek()) b.pop();
                if (b.isEmpty()) c[i]=-1;
                else c[i]=b.peek();
                b.push(a[i]);
            }
            for(int i=0;i<n;++i) System.out.printf("%d ",c[i]);
            System.out.println();
        }
        sc.close();
    }
}
