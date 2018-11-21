abstract class Animal {
    String name;
    int age;
    int weight;
    public Animal(String name,int age,int weight){
        this.name=name;
        this.age=age;
        this.weight=weight;
    }
    public void showInfo() {
        System.out.println("动物名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("重量：" + weight + "kg");
    }

    abstract void move();

    abstract void eat();
}
