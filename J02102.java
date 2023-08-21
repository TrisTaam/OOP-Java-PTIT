import java.util.*;

public class J02102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n*n];
        for(int i=0;i<n*n;++i) a[i]=sc.nextInt();
        Arrays.sort(a);
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int x=1;
        int y=1;
        int dir=0;
        int[][] b=new int[n+2][n+2];
        for(int i=0;i<=n+1;++i){
            b[0][i]=-1;
            b[n+1][i]=-1;
            b[i][0]=-1;
            b[i][n+1]=-1;
        }
        for(int i=0;i<n*n;++i){
            b[x][y]=a[i];
            x+=dx[dir];
            y+=dy[dir];
            if (b[x][y]!=0){
                x-=dx[dir];
                y-=dy[dir];
                dir=(dir+1)%4;
                x+=dx[dir];
                y+=dy[dir];
            }
        }
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j) System.out.printf("%d ",b[i][j]);
            System.out.println();
        }
        sc.close();
    }
}
