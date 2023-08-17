import java.util.Scanner;

public class J01024 {
    public static boolean res(String s){
        for(int i=0;i<s.length();++i)
            if (s.charAt(i)>'3') return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            String s=scanner.next();
            System.out.println(res(s)?"YES":"NO");
        }
        scanner.close();
    }
}
