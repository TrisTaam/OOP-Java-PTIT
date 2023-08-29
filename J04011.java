import java.util.Scanner;

class Vector{
    private int x;
    private int y;
    private int z;

    public Vector(Point3D p1,Point3D p2){
        this.x=(int)p2.getX()-p1.getX();
        this.y=(int)p2.getY()-p1.getY();
        this.z=(int)p2.getZ()-p1.getZ();
    }

    public Vector(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public void setX(int x){
        this.x=x;
    }

    public int getX(){
        return this.x;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getY(){
        return this.y;
    }

    public void setZ(int z){
        this.z=z;
    }

    public int getZ(){
        return this.z;
    }

    public static Vector direction(Vector v1,Vector v2){
        return new Vector(v1.y*v2.z-v1.z*v2.y,v1.z*v2.x-v1.x*v2.z,v1.x*v2.y-v1.y*v2.x);
    }

    public static int undirection(Vector v1,Vector v2){
        return v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
    }
}

class Point3D{
    private short x;
    private short y;
    private short z;

    public Point3D(int x,int y,int z){
        this.x=(short)x;
        this.y=(short)y;
        this.z=(short)z;
    }

    public void setX(short x){
        this.x=x;
    }

    public short getX(){
        return this.x;
    }

    public void setY(short y){
        this.y=y;
    }

    public short getY(){
        return this.y;
    }

    public void setZ(short z){
        this.z=z;
    }

    public short getZ(){
        return this.z;
    }

    public static boolean check(Point3D p1,Point3D p2,Point3D p3,Point3D p4){
        return Vector.undirection(Vector.direction(new Vector(p1,p2),new Vector(p1,p3)),new Vector(p1,p4))==0;
    }
}

public class J04011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
        if(Point3D.check(p1,p2,p3,p4)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        }
    }
}
