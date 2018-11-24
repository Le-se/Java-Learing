public class TestPerson {
    public static void main(String[] args) {
        Teacher test1=new Teacher("张三","男","1976/12/21","家里蹲大学","5438257");
        Student test2=new Student("李四","女","1999/11/11","单身女子学院","大二","机械工程","1702","201723170223");
        test1.printInfo();
        test2.printInfo();
    }
}
