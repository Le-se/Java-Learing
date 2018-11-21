public class Dog extends Animal {
    public Dog(String name,int age,int weight){
        super(name,age,weight);
    }
    public void move(){
    System.out.println("运动方式：走");
    }
    public void eat(){
    System.out.println("食物：杂食");
    }
}
