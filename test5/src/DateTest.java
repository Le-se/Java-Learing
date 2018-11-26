import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest{
    public static int JudgeSeason(int month){
        int season=0;
        switch (month){
            case 1:
            case 2:
            case 3:season=1;break;
            case 4:
            case 5:
            case 6:season=2;break;
            case 7:
            case 8:
            case 9:season=3;break;
            case 10:
            case 11:
            case 12:season=4;break;
        }
        return season;
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);//年份
        int month = now.get(Calendar.MONTH) + 1;//月份
        int week = now.get(Calendar.DAY_OF_WEEK);//星期
        int date = now.get(Calendar.DATE);//日期
        int hour = now.get(Calendar.HOUR_OF_DAY);//24小时制小时
        int minute = now.get(Calendar.MINUTE);//分钟
        int second = now.get(Calendar.SECOND);//秒
        System.out.println("当前年份：" +year);
        System.out.println("当前月份："+month);
        System.out.println("当前季度："+JudgeSeason(month));
        System.out.println("当前星期："+week);

        Date now2 = new Date();
        SimpleDateFormat test1 = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat test2 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat test3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(test1.format(now2));
        System.out.println(test2.format(now2));
        System.out.println(test3.format(now2));
    }
}
