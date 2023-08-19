import java.util.*;

public class J04001 {
    public static class Point{
        private double x;
        private double y;
        
        public Point(double x,double y){
            this.x=x;
            this.y=y;
        }

        public double getX(){
            return this.x;
        }

        public double getY(){
            return this.y;
        }

        public double distance(Point other){
            return Math.sqrt(Math.pow(this.x-other.getX(),2)+Math.pow(this.y-other.getY(),2));
        }

        @Override
        public String toString(){
            return super.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        double x;
        double y;
        while(t-->0){
            x=sc.nextDouble();
            y=sc.nextDouble();
            Point a=new Point(x,y);
            x=sc.nextDouble();
            y=sc.nextDouble();
            Point b=new Point(x,y);
            System.out.printf("%.4f\n",a.distance(b));
        }
        sc.close();
    }
}
