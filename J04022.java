import java.util.*;

class WordSet {
    private TreeSet<String> treeSet;

    public WordSet(TreeSet<String> treeSet) {
        this.treeSet = treeSet;
    }

    public WordSet(String s) {
        this.treeSet = new TreeSet<>();
        String[] tmp = s.trim().toLowerCase().split("\\s+");
        this.treeSet.addAll(Arrays.asList(tmp));
    }

    public WordSet union(WordSet a) {
        TreeSet<String> b = new TreeSet<>();
        b.addAll(this.treeSet);
        b.addAll(a.treeSet);
        return new WordSet(b);
    }

    public WordSet intersection(WordSet a) {
        TreeSet<String> b = new TreeSet<>();
        for (String x : a.treeSet)
            if (this.treeSet.contains(x)) b.add(x);
        return new WordSet(b);
    }

    @Override
    public String toString() {
        String s = "";
        for (String x : this.treeSet) s += (x + " ");
        return s;
    }
}

public class J04022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
