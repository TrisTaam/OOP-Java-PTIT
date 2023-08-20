import java.util.*;

public class J03022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> a=new ArrayList<>();
        while(sc.hasNext()){
            a.add(sc.next().toLowerCase());
        }
        boolean kt=true;
        for(int i=0;i<a.size();++i){
            char x=a.get(i).charAt(a.get(i).length()-1);
            if (x=='.'||x=='?'||x=='!'){
                if (a.get(i).length()>1){
                    if (kt) System.out.printf("%s ",a.get(i).substring(0,1).toUpperCase()+a.get(i).substring(1,a.get(i).length()-1));
                    else System.out.printf("%s ",a.get(i).substring(0,a.get(i).length()-1));
                }
                kt=true;
                System.out.println();
            }
            else{
                if (kt) System.out.printf("%s ",a.get(i).substring(0,1).toUpperCase()+a.get(i).substring(1));
                else System.out.printf("%s ",a.get(i));
                kt=false;
            }
        }
        sc.close();
    }
}
