public class ArrayUtil {
    public static int maxElement(int a[]) {//找数组中最大数值
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) max = a[i];//如果找到比之前的max更大的数字，则替换为新max
        }
        return max;
    }

    public static int average(int a[]) {//求平均值
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];//将数组中每个数字相加
        }
        return sum / a.length;//返回平均值
    }

    public static int search(int a[], int k) {//寻找数组中的特定数字
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) return i;//找到则返回当前位置（第一位为0）
        }
        return -1;//没找到则返回-1
    }

    public static void main(String[] args) {
        int[] test = new int[20];
        System.out.println("数组内容为：");
        for (int i = 0; i < test.length; i++) {
            test[i] = 60 + (int) (Math.random() * 41);//生成60-100的随机数并赋给数组
            System.out.print(test[i] + " ");//打印数组内容
        }
        System.out.print("\n");
        System.out.println("数组最大数字为：" + maxElement(test));//测试maxElement
        System.out.println("数组平均值为：" + average(test));//测试average
        int TestNum = 60 + (int) (Math.random() * 41);
        System.out.println("数字" + TestNum + "在数组中的位置为：" + search(test, TestNum));
    }
}
