import java.util.*;

public class J08028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;++i){
            a[i]=sc.nextInt();
            b[i]=m-a[i];
        }
        Stack<Integer> s=new Stack<>();
        int[] l=new int[n];
        for(int i=0;i<n;++i){
            while(!s.isEmpty()&&a[i]<=a[s.peek()]) s.pop();
            if (s.isEmpty()) l[i]=0;
            else l[i]=s.peek()+1;
            s.add(i);
        }
        s=new Stack<>();
        int[] r=new int[n];
        for(int i=n-1;i>=0;--i){
            while(!s.isEmpty()&&a[i]<=a[s.peek()]) s.pop();
            if (s.isEmpty()) r[i]=n-1;
            else r[i]=s.peek()-1;
            s.add(i);
        }
        long ans=Long.MIN_VALUE;
        for(int i=0;i<n;++i) ans=Math.max(ans,(long)a[i]*(r[i]-l[i]+1));
        s=new Stack<>();
        for(int i=0;i<n;++i){
            while(!s.isEmpty()&&b[i]<=b[s.peek()]) s.pop();
            if (s.isEmpty()) l[i]=0;
            else l[i]=s.peek()+1;
            s.add(i);
        }
        s=new Stack<>();
        for(int i=n-1;i>=0;--i){
            while(!s.isEmpty()&&b[i]<=b[s.peek()]) s.pop();
            if (s.isEmpty()) r[i]=n-1;
            else r[i]=s.peek()-1;
            s.add(i);
        }
        for(int i=0;i<n;++i) ans=Math.max(ans,(long)b[i]*(r[i]-l[i]+1));
        System.out.println(ans);
        sc.close();
    }
}
