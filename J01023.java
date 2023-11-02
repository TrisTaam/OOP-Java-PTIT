import java.util.*;

public class J01023 {
    public static void Try(int i,String s,String s1,ArrayList<String> ans){
        if (i==s.length()){
            ans.add(s1);
            return;
        }
        if (s.charAt(i)=='?'){
            if (i==0)
                for(char j='1';j<='9';++j) Try(i+1,s,s1+j,ans);
            else
                for(char j='0';j<='9';++j) Try(i+1,s,s1+j,ans);
        }
        else Try(i+1,s,s1+s.charAt(i),ans);
    }

    public static boolean isTrue(String s1,String s2,String s3,String operator){
        int a=Integer.parseInt(s1);
        int b=Integer.parseInt(s2);
        int c=Integer.parseInt(s3);
        if (operator.equals("+")) return a+b==c;
        if (operator.equals("-")) return a-b==c;
        if (operator.equals("*")) return a*b==c;
        if (operator.equals("/")) return a/b==c;
        return false;
    }

    public static String res(ArrayList<String> a,ArrayList<String> b,ArrayList<String> c,ArrayList<String> d){
        for(String x:a)
            for(String y:b)
                for(String z:c)
                    for(String t:d)
                        if (isTrue(x,y,z,t)) return String.format("%s %s %s = %s",x,t,y,z);
        return "WRONG PROBLEM!";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s1=sc.next();
            String operator=sc.next();
            String s2=sc.next();
            sc.next();
            String s3=sc.next();
            ArrayList<String> a=new ArrayList<>();
            ArrayList<String> b=new ArrayList<>();
            ArrayList<String> c=new ArrayList<>();
            Try(0,s1,"",a);
            Try(0,s2,"",b);
            Try(0,s3,"",c);
            ArrayList<String> d=new ArrayList<>();
            if (operator.equals("?")){
                d.add("+");
                d.add("-");
                d.add("*");
                d.add("/");
            }
            else d.add(operator);
            System.out.println(res(a,b,c,d));
        }
        sc.close();
    }
}