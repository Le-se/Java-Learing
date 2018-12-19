public class Rectangle extends Shape {
    private double width;
    private double len;

    public Rectangle(double width, double len) {
        this.width = width;
        this.len = len;
    }

    public double getArea() {
        return width * len;
    }
}
