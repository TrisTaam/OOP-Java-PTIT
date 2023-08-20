import java.util.*;

class Pair implements Comparable<Pair> {
    public Integer first;
    public Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.first != o.first)
            return this.first.compareTo(o.first);
        return this.second.compareTo(o.second);
    }

    @Override
    public String toString() {
        return String.format("%d %d", this.first, this.second);
    }
}

public class J02009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; ++i)
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        Arrays.sort(a);
        int ans=0;
        for(Pair x:a)
            if (x.first<=ans) ans+=x.second;
            else ans=x.first+x.second;
        System.out.println(ans);
        sc.close();
    }
}
