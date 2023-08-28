import java.util.*;

class Complex {
    private int real;
    private int virtual;

    public Complex(int real, int virtual) {
        this.real = real;
        this.virtual = virtual;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getVirtual() {
        return virtual;
    }

    public void setVirtual(int virtual) {
        this.virtual = virtual;
    }

    public Complex add(Complex a) {
        int b = this.real + a.real;
        int c = this.virtual + a.virtual;
        return new Complex(b, c);
    }

    public Complex multi(Complex a) {
        int b = this.real * a.real - this.virtual * a.virtual;
        int c = this.real * a.virtual + this.virtual * a.real;
        return new Complex(b, c);
    }

    @Override
    public String toString() {
        if (this.virtual >= 0) return String.format("%d + %di", this.real, this.virtual);
        return String.format("%d - %di", this.real, -this.virtual);
    }
}

public class J04018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Complex a = new Complex(sc.nextInt(), sc.nextInt());
            Complex b = new Complex(sc.nextInt(), sc.nextInt());
            Complex c = a.add(b);
            System.out.print(c.multi(a) + ", ");
            System.out.println(c.multi(c));
        }
        sc.close();
    }
}
