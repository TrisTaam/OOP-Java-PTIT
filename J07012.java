import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

class Pair<X extends Comparable, Y extends Comparable> implements Comparable<Pair> {
    private X first;
    private Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (!second.equals(o.second)) return -second.compareTo(o.second);
        return first.compareTo(o.first);
    }

    @Override
    public String toString() {
        return String.format("%s %s", first.toString(), second.toString());
    }
}

public class J07012 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ot = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) ot.readObject();
        HashMap<String, Integer> b = new HashMap<>();
        for (String x : a) {
            String[] tmp = x.toLowerCase().split("[^a-z0-9]+");
            for(String y : tmp)
                if (!y.isEmpty()) b.put(y, b.getOrDefault(y, 0) + 1);
        }
        ArrayList<Pair<String, Integer>> c = new ArrayList<>();
        for (Map.Entry<String, Integer> x : b.entrySet()) c.add(new Pair<>(x.getKey(), x.getValue()));
        Collections.sort(c);
        for (Pair<String, Integer> x : c) System.out.println(x);
        ot.close();
    }
}