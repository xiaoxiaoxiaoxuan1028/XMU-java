import java.math.BigInteger;

public class MyRational extends Number implements Comparable{
    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");

    public MyRational() {
        this(new BigInteger("0"), new BigInteger("1"));
    }

    public MyRational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = ((new BigInteger(denominator.compareTo(BigInteger.ZERO) + "")).multiply(numerator)).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = BigInteger.ONE;

        for(BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {
            if(n1.mod(k).compareTo(BigInteger.ZERO) == 0 && n2.mod(k).compareTo(BigInteger.ZERO) == 0)
                gcd = k;
        }

        return gcd;
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public MyRational add(MyRational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(
                denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new MyRational(n, d);
    }

    public MyRational subtract(MyRational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(
                denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new MyRational(n, d);
    }

    public MyRational multiply(MyRational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new MyRational(n, d);
    }

    public MyRational divide(MyRational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new MyRational(n, d);
    }

    @Override
    public String toString() {
        if(denominator.compareTo(BigInteger.ONE) == 0)
            return numerator.toString() + "";
        else
            return numerator.toString() + "/" + denominator.toString();
    }

    @Override
    public boolean equals(Object parm1) {
        if((this.subtract((MyRational)(parm1))).getNumerator().compareTo(BigInteger.ZERO) == 0)
            return true;
        else
            return false;
    }

    @Override
    public int intValue() {
        return (int)doubleValue();
    }

    @Override
    public float floatValue() {
        return (float)doubleValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() * 1.0 / denominator.doubleValue();
    }

    @Override
    public long longValue() {
        return (long)doubleValue();
    }

    @Override
    public int compareTo(Object o) {
        if((this.subtract((MyRational)o)).getNumerator().compareTo(BigInteger.ZERO) == 1)
            return 1;
        else if((this.subtract((MyRational)o)).getNumerator().compareTo(BigInteger.ZERO) == -1)
            return -1;
        else
            return 0;
    }
}
