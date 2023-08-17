import java.util.*;

public class J02005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        int m=scanner.nextInt();
        int[] b=new int[m];
        for(int i=0;i<n;++i) a[i]=scanner.nextInt();
        for(int i=0;i<m;++i) b[i]=scanner.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        LinkedHashSet<Integer> c = new LinkedHashSet<Integer>();
        for(int i=0;i<n;++i)
            if (Arrays.binarySearch(b,a[i])>=0) c.add(Integer.valueOf(a[i]));
        for (Integer x : c) System.out.print(x+" ");
        scanner.close();
    }
}
