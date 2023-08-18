import java.util.*;

public class J03009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String[] a=sc.nextLine().trim().split("\\s+");
            String[] b=sc.nextLine().trim().split("\\s+");
            ArrayList<String> c=new ArrayList<>();
            for(int i=0;i<a.length;++i)
                if (!c.contains(a[i])){
                    boolean kt=false;
                    for(int j=0;j<b.length;++j)
                        if (a[i].equals(b[j])){
                            kt=true;
                            break;
                        }
                    if (!kt) c.add(a[i]);
                }
            Collections.sort(c);
            for(String x:c) System.out.printf("%s ",x);
            System.out.println();
        }
        sc.close();
    }
}
