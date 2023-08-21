import java.util.*;

class Pair{
    public char first;
    public int second;

    public Pair(char first,int second){
        this.first=first;
        this.second=second;
    }
}

public class J03017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            int ans=0;
            ArrayList<Pair> a=new ArrayList<>();
            int end=0;
            int cnt=0;
            for(int i=0;i<s.length();++i){
                a.add(new Pair(s.charAt(i),i));
                if (a.size()>=3){
                    String tmp="";
                    for(int j=a.size()-3;j<a.size();++j) tmp+=a.get(j).first;
                    if (tmp.equals("100")){
                        if (end+1!=a.get(a.size()-3).second) cnt=0;
                        cnt+=a.get(a.size()-1).second-a.get(a.size()-3).second+1;
                        end=a.get(a.size()-1).second;
                        ans=Math.max(ans,cnt);
                        for(int j=0;j<3;++j) a.remove(a.size()-1);
                    }
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
