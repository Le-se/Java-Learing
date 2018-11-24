public class TestAnimal {
    public static void main(String[] args) {
        Animal bird = new Bird("Lucy", 2, 1);
        Animal dog = new Dog("Bob", 4, 25);
        bird.showInfo();
        bird.move();
        bird.eat();
        dog.showInfo();
        dog.move();
        dog.eat();
    }
}
