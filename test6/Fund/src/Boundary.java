import java.awt.*;
import javax.swing.*;

public class Boundary extends JFrame {
    //字体
    private Font f1 = new Font("微软雅黑", Font.PLAIN, 19);
    private Font f2 = new Font("微软雅黑", Font.PLAIN, 17);

    //构造方法
    public Boundary() {
        //创建一个窗口
        setTitle("2016 1.4-10.28 汇添富移动互联股票型基金 收益计算");//窗口标题
        setSize(345, 375);//窗口大小
        setLocationRelativeTo(null);//窗口显示在屏幕中间
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭方式
        //panel0
        JPanel jp0 = new JPanel();
        JLabel jl0 = new JLabel("请选择买入基金和卖出基金的时间");
        jl0.setFont(f1);
        jp0.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp0.add(jl0);

        //panel1
        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("买入时间：");
        JLabel chosemonth = new JLabel("月");
        JLabel choseday = new JLabel("日");
        jl1.setFont(f2);
        chosemonth.setFont(f2);
        choseday.setFont(f2);
        JComboBox buymonthchooser = new JComboBox();
        for (int i = 1; i <= 10; i++)
            buymonthchooser.addItem(i);
        JComboBox buydaychooser = new JComboBox();
        for (int i = 1; i <= 31; i++)
            buydaychooser.addItem(i);
        jp1.add(jl1);
        jp1.add(buymonthchooser);
        jp1.add(chosemonth);
        jp1.add(buydaychooser);
        jp1.add(choseday);

        //panel2
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("卖出时间：");
        JLabel chosemonth2 = new JLabel("月");
        JLabel choseday2 = new JLabel("日");
        jl2.setFont(f2);
        chosemonth2.setFont(f2);
        choseday2.setFont(f2);
        JComboBox sellmonthchooser = new JComboBox();
        for (int i = 1; i <= 10; i++)
            sellmonthchooser.addItem(i);
        JComboBox selldaychooser = new JComboBox();
        for (int i = 1; i <= 31; i++)
            selldaychooser.addItem(i);
        jp2.add(jl2);
        jp2.add(sellmonthchooser);
        jp2.add(chosemonth2);
        jp2.add(selldaychooser);
        jp2.add(choseday2);
        //panel3
        JPanel jp3 = new JPanel();
        jp3.setLayout(new GridLayout(4, 1, 10, 10));
        jp3.add(jp0);
        jp3.add(jp1);
        jp3.add(jp2);
        //panel4
        JButton sure = new JButton("计算");
        sure.setPreferredSize(new Dimension(80, 50));
        JPanel jp4 = new JPanel();
        jp4.add(sure);
        jp3.add(jp4);

        add(jp3);
        setVisible(true);//可视化
    }

    public static void main(String[] args) {
        new Boundary();
    }
}
