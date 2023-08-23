import java.io.*;
import java.util.*;

class WordSet {
    private DataInputStream dt;
    private TreeSet<String> a;
    private String data;

    public WordSet(String file) throws FileNotFoundException,IOException{
        this.dt = new DataInputStream(new FileInputStream(file));
        this.a=new TreeSet<>();
        this.data=getData();
    }

    public String getData() throws IOException{
        while (true){
            try{
                String[] b=dt.readLine().toLowerCase().split("\\s+");
                for(String x:b)
                    if (x!="") a.add(x);
            } catch(Exception e){
                break;
            }
        }
        String ans="";
        for(String x:a) ans+=(x+"\n");
        return ans;
    }

    @Override
    public String toString(){
        return data;
    }
}

public class J07007 {
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}