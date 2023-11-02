import java.util.*;
import java.io.*;

public class J07078 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("STRING.in"));
        int t=sc.nextInt();
        while(t-->0){
            String s1=sc.next();
            String s2=sc.next();
            int n1=s1.length();
            int n2=s2.length();
            for(int i=0;i<=n1-n2;++i) {
                int j=0;
                while(j<n2&&s1.charAt(i+j)==s2.charAt(j)) j++;
                if (j==n2) System.out.printf("%d ",i+1);
            }
            System.out.println();
        }
        sc.close();
    }
}
