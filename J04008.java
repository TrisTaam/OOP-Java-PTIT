import java.util.*;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

public class J04008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Point a=new Point(sc.nextDouble(),sc.nextDouble());
            Point b=new Point(sc.nextDouble(),sc.nextDouble());
            Point c=new Point(sc.nextDouble(),sc.nextDouble());
            double d1=a.distance(b);
            double d2=b.distance(c);
            double d3=c.distance(a);
            if (d1+d2>d3&&d2+d3>d1&&d3+d1>d2){
                System.out.printf("%.3f\n",d1+d2+d3);
            }
            else System.out.println("INVALID");
        }
        sc.close();
    }
}