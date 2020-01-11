class Octagon extends GeometricObject implements Comparable, Cloneable {
    double side;

    public Octagon() { }
    public Octagon(double side) {
        this.side = side;
    }
    public Octagon(double side, String color, boolean filled) {
        this.side = side;
        setColor(color);
        setFilled(filled);
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Object o) {
        if(this.side > ((Octagon)o).side)
            return 1;
        else if(this.side < ((Octagon)o).side)
            return -1;
        else
            return 0;
    }

}