package area.dao;

import area.service.Shape;

public class Rectangle implements Shape {
    private double length;
    private double width;
    private double area;
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    public double CountArea(){
        area=length*width;
        return area;
    }
    public void PrintArea(){
        System.out.println("矩形面积为："+String.format("%.2f", this.CountArea()));
    }

}
