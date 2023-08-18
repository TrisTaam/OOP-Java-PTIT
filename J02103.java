import java.util.*;

public class J02103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;++i){
            System.out.println("Test "+i+":");
            int n=sc.nextInt();
            int m=sc.nextInt();
            long[][] a=new long[n+5][m+5];
            for(int j=0;j<n;++j)
                for(int z=0;z<m;++z) a[j][z]=sc.nextLong();
            long[][] b=new long[m+5][n+5];
            for(int j=0;j<m;++j)
                for(int z=0;z<n;++z) b[j][z]=a[z][j];
            long[][] c=new long[n+5][n+5];
            for(int j=0;j<n;++j)
                for(int z=0;z<n;++z){
                    c[j][z]=0;
                    for(int p=0;p<m;++p) c[j][z]+=a[j][p]*b[p][z];
                }
            for(int j=0;j<n;++j){
                for(int z=0;z<n;++z) System.out.print(c[j][z]+" ");
                System.out.println();
            }
        }
        sc.close();
    }
}
