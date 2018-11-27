import java.util.Calendar;
import java.util.TimeZone;

public class DateTest {
    public static int JudgeSeason(int month) {
        int season = 0;
        switch (month) {
            case 1:
            case 2:
            case 3:
                season = 1;
                break;
            case 4:
            case 5:
            case 6:
                season = 2;
                break;
            case 7:
            case 8:
            case 9:
                season = 3;
                break;
            case 10:
            case 11:
            case 12:
                season = 4;
                break;
        }
        return season;
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();//获取当前时间
        Calendar timeofbj = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));//获取北京时间
        int year = now.get(Calendar.YEAR);//年份
        int month = now.get(Calendar.MONTH) + 1;//月份
        int week = now.get(Calendar.DAY_OF_WEEK);//星期
        System.out.println("当前年份：" + year);
        System.out.println("当前月份：" + month);
        System.out.println("当前季度：" + JudgeSeason(month));
        System.out.println("当前星期：" + week);

        String test1 = String.format("当前日期：%1$tY年%1$tm月%1$td日", now);
        String test2 = String.format("当前北京时间：%1$tH:%1$tM:%1$tS", timeofbj);
        String test3 = String.format("当前时间：%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", now);

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);

    }
}
