import java.util.*;

public class J03004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String[] a=sc.nextLine().trim().split("\\s+");
            for(String x:a)
                System.out.printf("%c%s ",Character.toUpperCase(x.charAt(0)),x.substring(1).toLowerCase());
            System.out.println();
        }
        sc.close();
    }
}