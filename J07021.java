import java.util.*;
import java.io.*;

public class J07021 {
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(new FileInputStream("DATA.in"));
            while(true){
                String s=sc.nextLine();
                if (s.equals("END")) break;
                ArrayList<String> a=new ArrayList<>();
                String tmp="";
                s=s.toLowerCase()+" ";
                for(int i=0;i<s.length();++i)
                    if (s.charAt(i)==' '){
                        if (!tmp.isEmpty()){
                            a.add(tmp);
                            tmp="";
                        }
                    }
                    else tmp+=s.charAt(i);
                for(String x:a) System.out.printf("%s ",x.substring(0,1).toUpperCase()+x.substring(1));
                System.out.println();
            }
        } catch (Exception e) {
        }
    }
}
