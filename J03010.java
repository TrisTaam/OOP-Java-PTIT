import java.util.*;

public class J03010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        HashMap<String,Integer> b=new HashMap<>();
        while(t-->0){
            String[] a=sc.nextLine().trim().split("\\s+");
            String s=a[a.length-1].toLowerCase();
            for(int i=0;i<a.length-1;++i) s+=Character.toLowerCase(a[i].charAt(0));
            if (!b.containsKey(s)) b.put(s,1);
            else b.put(s,b.get(s)+1);
            if (b.get(s)>1) s+=b.get(s).toString();
            System.out.printf("%s@ptit.edu.vn\n",s);
        }
        sc.close();
    }
}