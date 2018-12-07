public class TestShape {
    public static void main(String[] args) {
        try {
            if(args.length==1){
                Circle obj=new Circle(Double.valueOf(args[0]));
                System.out.println("The area of circle is :"+obj.getArea());
            }
            else if(args.length==2){
                Rectangle obj=new Rectangle(Double.valueOf(args[0]),Double.valueOf(args[1]));
                System.out.println("The area of rectangle is :"+obj.getArea());
            }
            else if(args.length==3){
                Triangle obj=new Triangle(Double.valueOf(args[0]),Double.valueOf(args[1]),Double.valueOf(args[2]));
                System.out.println("The area of triangle is :"+obj.getArea());
            }
            else throw new ArrayIndexOutOfBoundsException();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong number of arguments!");
        }catch (NumberFormatException e){
            System.out.println("Wrong type of arguments!");
        }
    }
}
