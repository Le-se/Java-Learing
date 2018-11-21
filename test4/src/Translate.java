import java.util.Scanner;
public class Translate {
    public static boolean isNum(String str){    //判断输入的字符串是否为数字
        for (int i=0;i<str.length();i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String x[]={"zero","one","two", "three","four", "five","six","seven", "eight","nine"} ; //0-9 or 个位
        String y[]={"ten","eleven","twelve","thirteen","fourteen","fifteen",
                "sixteen","seventeen","eighteen","nineteen" };  //10-19
        String z[]={"twenty","thirty","forty","fifty",  "sixty","seventy",  //整十的数字（除10以外） or 十位
                "eighty","ninety"};
        Scanner in = new Scanner(System.in);
        System.out.println("请输入0-99的数字或英文，输入##停止翻译");
        while (true){
            String s;
            s = in.nextLine();  //输入字符串
            if(s.equals("##")) break; //输入“##”表示结束
            if(isNum(s)){   //数字翻译为英文
                int num = Integer.parseInt(s);  //将（全为数字的）字符串转化为数字
                if(num<10) System.out.println(x[num]);  //0-9
                else if(num<20) System.out.println(y[num-10]);  //10-19
                else if(num<100 && num%10==0) System.out.println(z[num/10-2]);  //20及以上的整十
                else if(num<100 ) System.out.println(z[num/10-2]+" "+x[num%10]);    //21-99（除整十以外）
                else System.out.println("Too Large!");  //大于99的数
            }
            else {//英文翻译成数字
                int i, num = 0;
                if (s.split(" ").length == 1) {//只有一个英文单词的数字
                    for (i = 0; i < 10; i++) { //0-9
                        if (s.equals(x[i])) {
                            num += i;
                            System.out.println(num);
                            break;
                        }
                        else if (s.equals(y[i])) { //10-19
                            num = num + i + 10;
                            System.out.println(num);
                            break;
                        }
                    }
                    for (i = 0; i < 8; i++) {  //20及以上的整十
                        if (s.equals(z[i])) {
                            num = num + i * 10 + 20;
                            System.out.println(num);
                            break;
                        }
                    }
                }
                else if(s.split(" ").length ==2){
                    String[] subStr=s.split(" ");
                    for (i = 0; i < 8; i++) {  //十位
                        if (subStr[0].equals(z[i])) {
                            num = num + i * 10 + 20;
                            break;
                        }
                    }
                    for (i = 0; i < 10; i++) { //个位
                        if (subStr[1].equals(x[i])) {
                            num += i;
                            break;
                        }
                    }
                    System.out.println(num);
                }
                else System.out.println("Error!");  //输入错误或过大的英文
            }
        }
        System.out.println("翻译结束!");
    }
}
