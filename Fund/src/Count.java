import java.io.*;

public class Count {

    public static boolean legal(int bmon, int bday, int smon, int sday) throws FileNotFoundException {
        String buy = bmon + "-" + bday;//买入日期
        String sell = smon + "-" + sday;//卖出日期
        double buym = search(buy);//买入净值
        double sellm = search(sell);//卖出净值
        int interval = interval(bmon, bday, smon, sday);
        if (buym == 0 || sellm == 0 || interval < 0)
            return false;
        return true;
    }

    public static double search(String date) throws FileNotFoundException {//寻找净值
        File file = new File("data.txt");
        FileReader fr = new FileReader(file);
        try {
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                String str[] = s.split("@@");
                if (date.equals(str[0])) {
                    return Double.parseDouble(str[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int during(int month, int day) {//计算绝对天数
        int days[] = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
        return days[month - 1] + day;
    }

    public static String buyrate(int money) {
        if (money < 1000000) {
            return "0.15%";
        } else if (money < 5000000) {
            return "0.10%";
        } else if (money < 10000000) {
            return "0.03%";
        } else {
            return "1000元/笔";
        }
    }

    public static String sellrate(int interval) {
        if (interval < 7) {
            return "1.5%";
        } else if (interval < 30) {
            return "0.75%";
        } else if (interval < 180) {
            return "0.50%";
        } else {
            return "0.00%";
        }
    }

    public static int interval(int bmon, int bday, int smon, int sday) {
        int interval = during(smon, sday) - during(bmon, bday);
        return interval;
    }

    public static double count(int bmon, int bday, int smon, int sday, int money) throws FileNotFoundException {//计算净赚
        int interval = interval(bmon, bday, smon, sday);//间隔日期
        String buy = bmon + "-" + bday;//买入日期
        String sell = smon + "-" + sday;//卖出日期
        double buym = search(buy);//买入净值
        double sellm = search(sell);//卖出净值
        double result = -1;//结果，为-1时代表输入错误
        double num = 0;
        if (!legal(bmon, bday, smon, sday))
            return -1;
        if (money < 1000000) {
            num = money / buym / 1.0015;
        } else if (money < 5000000) {
            num = money / buym / 1.001;
        } else if (money < 10000000) {
            num = money / buym / 1.0003;
        } else {
            num = (money - 1000) / buym;
        }
        if (interval < 7) {
            result = num * 0.985 * sellm;
        } else if (interval < 30) {
            result = num * 0.9925 * sellm;
        } else if (interval < 180) {
            result = num * 0.995 * sellm;
        } else {
            result = num * sellm;
        }
        result = result - money;
        return result;
    }
}
