import java.util.Scanner;


public class J01025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] a=new int[2][4];
        for(int i=0;i<2;++i)
            for(int j=0;j<4;++j) a[i][j]=scanner.nextInt();
        int x1=Math.min(a[0][0],a[1][0]);
        int y1=Math.min(a[0][1],a[1][1]);
        int x2=Math.max(a[0][2],a[1][2]);
        int y2=Math.max(a[0][3],a[1][3]);
        int h=Math.max(x2-x1,y2-y1);
        System.out.println(h*h);
        scanner.close();
    }
}
