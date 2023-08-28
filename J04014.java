import java.util.*;

class PhanSo {
    private long tu;
    private long mau;

    public PhanSo(long tu, long mau) {
        if (mau < 0){
            tu = -tu;
            mau = -mau;
        }
        long x = PhanSo.gcd(tu, mau);
        this.tu = tu / x;
        this.mau = mau / x;
    }

    public long getTu() {
        return tu;
    }

    public void setTu(long tu) {
        this.tu = tu;
    }

    public long getMau() {
        return mau;
    }

    public void setMau(long mau) {
        this.mau = mau;
    }

    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b > 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public PhanSo add(PhanSo a) {
        long b = this.tu * a.mau + this.mau * a.tu;
        long c = this.mau * a.mau;
        return new PhanSo(b, c);
    }

    public PhanSo multi(PhanSo a) {
        long b = this.tu * a.tu;
        long c = this.mau * a.mau;
        return new PhanSo(b, c);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.tu, this.mau);
    }
}

public class J04014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
            PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());
            PhanSo c = a.add(b);
            c = c.multi(c);
            PhanSo d = a.multi(b).multi(c);
            System.out.print(c+" ");
            System.out.println(d);
        }
        sc.close();
    }
}
