import java.io.*;
import java.util.*;

public class J07040 {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        ObjectInputStream ot=new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> a=(ArrayList<String>) ot.readObject();
        TreeSet<String> b=new TreeSet<>();
        for(String x:a){
            String[] c=x.trim().toLowerCase().split("\\s+");
            b.addAll(Arrays.asList(c));
        }
        ot.close();
        Scanner sc=new Scanner(new File("VANBAN.in"));
        while(sc.hasNext()){
            String s=sc.next().toLowerCase();
            if (b.contains(s)){
                System.out.println(s);
                b.remove(s);
            }
        }
    }
}