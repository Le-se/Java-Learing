public class Bird extends Animal{
    public Bird(String name,int age,int weight){
        super(name,age,weight);
    }
    public void move() {
        System.out.println("运动方式：飞行");
    }
    public void eat(){
        System.out.println("食物：谷物、虫");
    }
}
