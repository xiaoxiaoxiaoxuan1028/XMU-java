package test;

public class Test {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Area: " + triangle1.getArea());
        System.out.println("Perimeter: " + triangle1.getPerimeter());
        System.out.println(triangle1.toString());

        triangle1.setColor("black");
        System.out.println("Color: " + triangle1.getColor());
        triangle1.setFilled(true);
        System.out.println("isFilled: " + triangle1.isFilled());
    }
}