import java.util.Scanner;

public class J01017 {
    public static boolean res(String s){
        for(int i=0;i<s.length()-1;++i)
            if (Math.abs(s.charAt(i)-s.charAt(i+1))!=1) return false;
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
