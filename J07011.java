import java.io.File;
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

public class J07011 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        HashMap<String, Integer> b = new HashMap<>();
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] a = sc.nextLine().toLowerCase().split("[^a-z0-9]+");
            for (String x : a)
                if (!x.isEmpty()) b.put(x, b.getOrDefault(x, 0) + 1);
        }
        ArrayList<Pair<String, Integer>> c = new ArrayList<>();
        for (Map.Entry<String, Integer> x : b.entrySet()) c.add(new Pair<>(x.getKey(), x.getValue()));
        Collections.sort(c);
        for (Pair<String, Integer> x : c) System.out.println(x);
        sc.close();
    }
}