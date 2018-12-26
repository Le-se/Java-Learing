import java.io.*;
import java.lang.management.MonitorInfo;

public class Count {

    public static boolean legal(int bmon, int bday, int smon, int sday) throws FileNotFoundException {
        String buy = bmon + "-" + bday;//买入日期
        String sell = smon + "-" + sday;//卖出日期
        String[] binfo=search(buy).split("@@");//买入信息
        String[] sinfo=search(sell).split("@@");//卖出信息
        double buym = Double.parseDouble(binfo[1]);//买入净值
        double sellm = Double.parseDouble(sinfo[1]);//卖出净值
        int interval = interval(bmon, bday, smon, sday);
        if (buym == 0 || sellm == 0 || interval < 0)
            return false;
        return true;
    }

    public static String search(String date) throws FileNotFoundException {//寻找净值
        File file = new File("data.txt");
        FileReader fr = new FileReader(file);
        try {
            BufferedReader br = new BufferedReader(fr);
            String loc="0-0@@0";//当前字符串
            while (true) {
                String tmp=loc;
                String[] p=tmp.split("-|@@");//上个字符串
                int[] pre=new int[2];//上条日期信息
                for(int i=0;i<2;i++){
                    pre[i]=Integer.parseInt(p[i]);
                }
                loc= br.readLine();
                if (loc==null){
                     return "0-0@@0";
                }
                String[] s = loc.split("-|@@");
                int[] str=new int[2];//文档当前日期信息
                for(int i=0;i<2;i++){
                    str[i]=Integer.parseInt(s[i]);
                }
                String d[]=date.split("-");
                int[] dinfo=new int[2];//输入日期信息
                for(int i=0;i<2;i++){
                    dinfo[i]=Integer.parseInt(d[i]);
                }
                if (dinfo[0]==str[0]) {
                    if(dinfo[1]==str[1]) {//日期一样
                        return loc;
                    }
                    else if(dinfo[1]<pre[1]&&dinfo[1]>str[1])//月中的休息日
                    {
                        return tmp;
                    }
                    else if (dinfo[0]<pre[0]&&dinfo[1]>str[1]){//月末休息日
                        return tmp;
                    }
                }
                else if(dinfo[0]==pre[0]&&dinfo[0]>str[0]){
                    return tmp;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "0-0@@0";
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
        String[] binfo=search(buy).split("@@");//买入信息
        String[] sinfo=search(sell).split("@@");//卖出信息
        double buym = Double.parseDouble(binfo[1]);//买入净值
        double sellm = Double.parseDouble(sinfo[1]);//卖出净值
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

    public static boolean lastday(int month,int day){
        if((month==2&&day==29)||(month==3&&day==31)||(month==4&&day==30)
        ||(month==5&&day==31)||(month==6&&day==30)||(month==7&&day==31)
        ||(month==8&&day==31)||(month==9&&day==30))
            return true;
        return false;
    }

    public static void main(String[] args) {
        try {
            System.out.println(search("1-2"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
