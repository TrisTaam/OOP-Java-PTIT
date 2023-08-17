import java.util.*;

public class J02017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<n;++i){
            int a=sc.nextInt();
            if (s.empty()) s.push(a);
            else if ((s.peek()+a)%2==0) s.pop();
            else s.push(a);
        }
        System.out.println(s.size());
        sc.close();
    }
}
