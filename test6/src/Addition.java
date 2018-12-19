import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String add = input.next();
        String[] numbers = add.split("\\+");
        try {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += Integer.parseInt(numbers[i]);
            }
            System.out.println("和为：" + sum);
        } catch (NumberFormatException e) {
            System.out.println("表达式格式有误！");
        }
    }
}
