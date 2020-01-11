public class Test1 {
    public static void main(String[] args) {
        Octagon o = new Octagon(5);

        System.out.println("Area: " + o.getArea());
        System.out.println("Perimeter: " + o.getPerimeter());

        Octagon o1 = new Octagon();
        try {
            o1 = (Octagon)o.clone();
        }
        catch(CloneNotSupportedException ex) {
            System.out.println("CloneNotSupportedException");
        }

        System.out.println(o.compareTo(o1));
    }
}
