import java.util.Scanner;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isTriangle() {
        try {
            if (a + b > c && a + c > b && b + c > a)
                return true;
            else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(a + "," + b + "," + c + "不能构成三角形！");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        Triangle tri = new Triangle(a, b, c);
        if (tri.isTriangle()) System.out.println("可以构成三角形");
    }
}
