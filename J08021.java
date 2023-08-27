import java.util.*;

public class J08021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            Stack<Integer> a=new Stack<>();
            a.push(-1);
            int ans=0;
            for(int i=0;i<s.length();++i)
                if (s.charAt(i)=='(') a.push(i);
                else{
                    a.pop();
                    if (a.isEmpty()) a.push(i);
                    else ans=Math.max(ans,i-a.peek());
                }
            System.out.println(ans);
        }
        sc.close();
    }    
}
