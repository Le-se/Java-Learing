package area.dao;

import area.service.Shape;

public class Triangle implements Shape{
    private double LineA;
    private double LineB;
    private double LineC;
    private double area;
    public Triangle(double a,double b,double c){
        this.LineA=a;
        this.LineB=b;
        this.LineC=c;
    }

    public double CountArea() {
        area=Math.sqrt((LineA+LineB+LineC)*(LineA+LineB-LineC)*(LineA+LineC-LineB)*(LineB+LineC-LineA))/4;
        return area;
    }
    public void PrintArea(){
        System.out.println("三角形的面积为："+String.format("%.2f", this.CountArea()));
    }
}
