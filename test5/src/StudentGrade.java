import java.util.*;

public class StudentGrade {
    private String name;
    private int sex;
    private int number;
    private int grade;

    public void getName() {
        Random random = new Random();
        String[] surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "孔", "方", "何", "张", "冯"};//姓
        String girlsname = "秀娟英华慧巧美娜静淑惠珠翠雅";//女名
        String boysname = "伟刚勇毅俊峰强军平保永健富贵";//男名
        String name = surname[random.nextInt(surname.length - 1)];//先获得姓
        if (this.sex == 1) {
            int choice = random.nextInt(boysname.length() - 1);
            this.name = name + boysname.substring(choice, choice + random.nextInt(2) + 1);
            //生成最多三个字的名字
        } else {
            int choice = random.nextInt(girlsname.length() - 1);
            this.name = name + girlsname.substring(choice, choice + random.nextInt(2) + 1);
            //生成最多三个字的名字
        }

    }

    public StudentGrade(int n) {
        number = 20130300 + n;
        grade = (int) (Math.random() * 41 + 60);
        sex = (int) (Math.random() * 2);//1为男，0为女
        getName();
    }

    public static void uselist() {
        List<StudentGrade> test = new ArrayList<StudentGrade>();
        for (int i = 1; i <= 30; i++) {
            test.add(new StudentGrade(i));
        }
        Collections.sort(test, new Comparator<StudentGrade>() {
            @Override
            public int compare(StudentGrade o1, StudentGrade o2) {
                return o2.grade - o1.grade;
            }//排序
        });
        for (StudentGrade stu : test) {
            System.out.println(stu.number + "  " + stu.name + "\t\t" + (stu.sex == 1 ? "男" : "女") + "\t" + stu.grade);
        }//遍历
    }

    public static void usemap() {
        Map<Integer, StudentGrade> test = new TreeMap<Integer, StudentGrade>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }//排序规则
                });
        for (int i = 1; i <= 30; i++) {
            StudentGrade stu = new StudentGrade(i);
            test.put(stu.grade, stu);
        }//放入元素
        for (Map.Entry<Integer, StudentGrade> entry : test.entrySet()) {
            System.out.println(entry.getValue().number + "  " + entry.getValue().name
                    + "\t\t" + (entry.getValue().sex == 1 ? "男" : "女") + "\t" + entry.getKey());
        }//遍历
    }

    public static void main(String[] args) {
        System.out.println("使用List实现：");
        uselist();
        System.out.println("使用Map实现：");
        usemap();
    }
}
