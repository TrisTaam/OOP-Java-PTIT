import java.util.*;

public class J03029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] a=sc.nextLine().toLowerCase().split("\\s+");
            String b="";
            for(int i=0;i<a.length;++i){
                if (a[i].equals(".")||a[i].equals("!")||a[i].equals("?")){
                    b=b.substring(0,b.length()-1)+a[i];
                    System.out.println(b);
                    b="";
                }
                else{
                    if (b.isEmpty()) a[i]=a[i].substring(0,1).toUpperCase()+a[i].substring(1);
                    b+=(a[i]+" ");
                    char x=a[i].charAt(a[i].length()-1);
                    if (x=='.'||x=='!'||x=='?'){
                        System.out.println(b);
                        b="";
                    }
                }
            }
            if (!b.isEmpty()) System.out.println(b.substring(0,b.length()-1)+".");
        }
        sc.close();
    }
}
