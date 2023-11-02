import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> set;

    public WordSet(String file) throws IOException {
        set = new TreeSet<>();
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNext()) set.add(sc.next().toLowerCase());
    }

    public WordSet(TreeSet<String> set) {
        this.set = set;
    }

    public WordSet union(WordSet o) {
        TreeSet<String> tmp = new TreeSet<>();
        tmp.addAll(set);
        tmp.addAll(o.set);
        return new WordSet(tmp);
    }

    public WordSet intersection(WordSet o) {
        TreeSet<String> tmp = new TreeSet<>();
        for (String x : set)
            if (o.set.contains(x)) tmp.add(x);
        return new WordSet(tmp);
    }

    @Override
    public String toString() {
        String s = "";
        for (String x : set) s += (x + " ");
        return s;
    }
}

public class J07014 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
