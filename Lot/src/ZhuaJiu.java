import java.util.ArrayList;
import java.util.Random;

public class ZhuaJiu {

    public static void main(String[] args) {
        String[] people = {"朱琼宇","胡致华","朱冰倩","孟祥宇","沈海昕","羊含笑",
                "孙高航","邹浩宇"};// 抓阄的八个人
        String[] jiu = {"戴美怡","沈艳","王洁连","孙忠祥&陈曦","梁锦豪","韩帅","邓均钰","方程鹏"};// 八个阄
        ArrayList<String> jiulist = new ArrayList<String>();//用来存放已经被抓出的阄
        Random rm = new Random();
        for (int i = 0; i < 8; i++) {
            System.out.print(people[i] + "抓的阄是:");
            for (; ; ) {
                int r = rm.nextInt(8);//随机产生大于等于0小于8的数
                if (!jiulist.contains(jiu[r])) {//如果没有被抽到过
                    jiulist.add(jiu[r]);//则放入jiulist中
                    System.out.println(jiu[r]);//打印被抓出的阄
                    break;//换一个人抓
                }
            }
        }

    }
}