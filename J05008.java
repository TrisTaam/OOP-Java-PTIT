import java.util.*;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point o) {
        return Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
    }
}

class Polygon {
    private Point[] p;

    public Polygon(Point[] p) {
        this.p = p;
    }

    public String getArea() {
        double area = 0.f;
        for (int i = 1; i < p.length - 1; ++i) {
            double a = p[0].distanceTo(p[i]);
            double b = p[0].distanceTo(p[i + 1]);
            double c = p[i].distanceTo(p[i + 1]);
            double half = (a + b + c) / 2;
            area += Math.sqrt(half * (half - a) * (half - b) * (half - c));
        }
        return String.format("%.3f", area);
    }
}

public class J05008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Point p[] = new Point[n];
            for (int i = 0; i < n; i++) {
                p[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            Polygon poly = new Polygon(p);
            System.out.println(poly.getArea());
        }
        sc.close();
    }
}