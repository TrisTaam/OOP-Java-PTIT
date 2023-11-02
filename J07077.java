import java.util.*;
import java.io.*;

public class J07077 {
    public static boolean isDigit(char x){
        return x>='0'&&x<='9';
    }

    public static int res(String s){
        if (s.equals("*")||s.equals("/")) return 2;
        if (s.equals("+")||s.equals("-")) return 1;
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("BIEUTHUC.in"));
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            Stack<String> a=new Stack<>();
            Stack<String> b=new Stack<>();
            String s1="";
            for(int i=0;i<s.length();++i)
                if (isDigit(s.charAt(i))) s1+=s.charAt(i);
                else{
                    String x=Character.toString(s.charAt(i));
                    if (s1!=""){
                        a.push(s1);
                        s1="";
                    }
                    if (x.equals("(")) b.add(x);
                    else if (x.equals(")")){
                        while(!b.isEmpty()&&!b.peek().equals("(")) a.push(b.pop());
                        b.pop();
                    }
                    else{
                        if (res(x)>0){
                            while(!b.isEmpty()&&res(b.peek())>=res(x)) a.push(b.pop());
                            b.push(x);
                        }
                    }
                }
            if (s1!="") a.push(s1);
            while(!b.isEmpty()) a.push(b.pop());
            Stack<String> c=new Stack<>();
            for(String x:a)
                if (res(x)==0) c.push(x);
                else{
                    long p=Long.parseLong(c.pop());
                    long q=Long.parseLong(c.pop());
                    if (x.equals("+")) c.push(Long.toString(q+p));
                    else if (x.equals("-")) c.push(Long.toString(q-p));
                    else if (x.equals("*")) c.push(Long.toString(q*p));
                    else if (x.equals("/")) c.push(Long.toString(q/p));
                }
            System.out.println(c.peek());
        }
        sc.close();
    }
}
