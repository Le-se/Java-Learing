package area.action;

import area.dao.*;

public class ShapeTest {
    public static void main(String[] args) {
        Circle TestCircle = new Circle(2);
        Rectangle TestRectangle = new Rectangle(1,2);
        Triangle TestTriangle = new Triangle(1,1,1);
        TestCircle.PrintArea();
        TestRectangle.PrintArea();
        TestTriangle.PrintArea();
    }
}
