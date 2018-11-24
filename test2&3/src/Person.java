public class Person {
    String name;
    String sex;
    String birthday;

    public Person(String name, String sex, String birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public void printInfo() {
        System.out.println("姓名：" + name);
        System.out.println("性别:" + sex);
        System.out.println("生日：" + birthday);
    }
}
