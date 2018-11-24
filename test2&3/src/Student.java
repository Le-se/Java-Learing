public class Student extends Person {
    private String school;
    private String grade;
    private String major;
    private String Class;
    private String stuID;

    public Student(String name, String sex, String birthday, String school, String grade, String major, String Class, String stuID) {
        super(name, sex, birthday);
        this.school = school;
        this.grade = grade;
        this.major = major;
        this.Class = Class;
        this.stuID = stuID;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("学校：" + school);
        System.out.println("年级：" + grade);
        System.out.println("专业：" + major);
        System.out.println("班级：" + Class);
        System.out.println("学生学号：" + stuID);
    }
}
