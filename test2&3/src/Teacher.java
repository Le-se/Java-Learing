public class Teacher extends Person {
    private String school;
    private String teaID;

    public Teacher(String name, String sex, String birthday, String school, String teaID) {
        super(name, sex, birthday);
        this.school = school;
        this.teaID = teaID;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("学校："+school);
        System.out.println("工号"+teaID);
    }
}
