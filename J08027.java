import java.util.Scanner;
import java.util.Stack;

public class J08027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        for(int i=0;i<s.length();++i)
            if (s.charAt(i)=='-'){
                if (!s1.isEmpty()) s1.pop();
            }
            else if (s.charAt(i)=='<'){
                if (!s1.isEmpty()){
                    s2.push(s1.peek());
                    s1.pop();
                }
            }
            else if (s.charAt(i)=='>'){
                if (!s2.isEmpty()){
                    s1.push(s2.peek());
                    s2.pop();
                }
            }
            else s1.push(s.charAt(i));
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }
        while(!s2.isEmpty()){
            System.out.print(s2.peek());
            s2.pop();
        }
        sc.close();
    }
}
