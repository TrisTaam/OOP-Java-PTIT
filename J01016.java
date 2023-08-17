import java.util.Scanner;

public class J01016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        int cnt=0;
        for(int i=0;i<s.length();++i){
            char x=s.charAt(i);
            if (x=='4'||x=='7') cnt++;
        }
        System.out.println((cnt==4||cnt==7)?"YES":"NO");
        scanner.close();
    }
}
