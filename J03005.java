import java.util.*;

public class J03005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String[] a=sc.nextLine().trim().split("\\s+");
            a[0]=a[0].toUpperCase();
            for(int i=1;i<a.length;++i) a[i]=Character.toUpperCase(a[i].charAt(0))+a[i].substring(1).toLowerCase();
            if (a.length==1) System.out.println(a[0]);
            else{
                for(int i=1;i<a.length-1;++i) System.out.printf("%s ",a[i]);
                System.out.printf("%s, %s",a[a.length-1],a[0]);
                System.out.println();
            }
        }
        sc.close();
    }
}