public class Triangle {
    private int a;
    private int b;
    private int c;//三角形的三条边

    public void setA(int x) {
        a = x;
    }

    public void setB(int x) {
        b = x;
    }

    public void setC(int x) {
        c = x;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    private boolean isTriangle() {
        if (a + b > c && a + c > b && b + c > a)
            return true;
        else
            return false;
    }

    public void getArea() {
        if (this.isTriangle()) {
            double Area = Math.sqrt((a + b + c) * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
            System.out.println("此三角形的面积为：" + String.format("%.2f", Area));
        } else {
            System.out.println("边长为" + a + "," + b + "和" + c + "的三条边无法构成三角形");
        }
    }

    public static void main(String[] args) {
        Triangle test = new Triangle();
        test.setA((int) (Math.random() * 20));
        test.setB((int) (Math.random() * 20));
        test.setC((int) (Math.random() * 20));
        System.out.println("三角形三边长分别为：" + test.getA() + "," + test.getB() + "和" + test.getC());
        test.getArea();
    }
}
