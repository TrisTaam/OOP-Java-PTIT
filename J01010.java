import java.util.Scanner;

public class J01010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        scanner.nextLine();
        while(t-->0){
            String s=scanner.nextLine();
            String ans="";
            for(int i=0;i<s.length();++i){
                char x=s.charAt(i);
                if (x=='0'||x=='8'||x=='9') ans+="0";
                else if (x=='1') ans+="1";
                else{
                    ans="INVALID";
                    break;
                }
            }
            int start;
            for(start=0;start<ans.length();++start)
                if (ans.charAt(start)!='0') break;
            if (start==ans.length()&&ans.charAt(ans.length()-1)=='0') System.out.println("INVALID");
            else System.out.println(ans.substring(start,ans.length()));
        }
        scanner.close();
    }
}
