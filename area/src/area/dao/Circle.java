package area.dao;

import area.service.Shape;

public class Circle implements Shape {
    private double radius;
    private double area;
    public Circle(double radius){
        this.radius=radius;
    }
    public double CountArea(){
    area=radius*radius*3.14;
    return area;
    }
    public void PrintArea(){
        System.out.println("圆形面积为："+String.format("%.2f", this.CountArea()));
    }

}
