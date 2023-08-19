import java.util.*;

class Rectangle {
    private double width;
    private double height;
    private String color;

    public Rectangle(double width, double height, String color) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException();
        this.width = width;
        this.height = height;
        this.color = Character.toUpperCase(color.charAt(0)) + color.substring(1).toLowerCase();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double findArea() {
        return this.width * this.height;
    }

    public double findPerimeter() {
        return (this.width + this.height) * 2;
    }
}

public class J04002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Rectangle a = new Rectangle(sc.nextInt(), sc.nextInt(), sc.next());
            System.out.printf("%.0f %.0f %s", a.findPerimeter(), a.findArea(), a.getColor());
        } catch (Exception e) {
            System.out.println("INVALID");
        }
        sc.close();
    }
}