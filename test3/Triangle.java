package test;

public class Triangle extends GeometricObject {
    private double a = 1.0;
    private double b = 1.0;
    private double c = 1.0;

    public Triangle() {
        super();
    }

    public Triangle(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + a + " side2 = " + b + " side3 = " + c;
    }
}
