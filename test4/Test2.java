import java.math.BigInteger;

public class Test2 {
    public static void main(String[] args) {
        BigInteger numerator = new BigInteger("1");
        BigInteger denominator = new BigInteger("10000");
        MyRational r1 = new MyRational(numerator, denominator);
        MyRational r2 = new MyRational(numerator, denominator);
        MyRational r3 = new MyRational(numerator, denominator);
        System.out.println("r1 + r2 + r3 = " + r1.add(r2).add(r3));
        System.out.println("r1 - r2 - r3 = " + r1.subtract(r2).subtract(r3));
        System.out.println("r1 * r2 * r3 = " + r1.multiply(r2).multiply(r3));
        System.out.println("r1 / r2 / r3 = " + r1.divide(r2).divide(r3));
    }
}
