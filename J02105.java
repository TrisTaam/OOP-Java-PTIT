import java.util.*;

public class J02105 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;++i){
            System.out.printf("List(%d) = ",i);
            for(int j=1;j<=n;++j)
                if (sc.nextInt()==1) System.out.printf("%d ",j);
            System.out.println();
        }
        sc.close();
    }
}