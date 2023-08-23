import java.util.*;

public class J02033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        boolean kt=false;
        long s=0;
        for(int i=0;i<n;++i){
            int x=sc.nextInt();
            s+=x;
            if (x>0) a.add(x);
            else if (x<0) b.add(x);
            else kt=true;
        }
        Collections.sort(a);
        Collections.sort(b);
        for(int i=0;i<b.size()&&k>0;++i,--k) s+=(-b.get(i))*2;
        if (k%2==1&&!kt){
            if (a.isEmpty()){
                if (!b.isEmpty()) s-=Math.abs(b.get(b.size()-1))*2;
            }
            else if (b.isEmpty()) s-=a.get(0)*2;
            else s-=Math.min(a.get(0),Math.abs(b.get(b.size()-1)))*2;
        }
        System.out.println(s);
        sc.close();
    }
}
