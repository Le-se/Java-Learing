import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Boundary extends JFrame {
    //字体
    private Font f1 = new Font("微软雅黑", Font.PLAIN, 21);
    private Font f2 = new Font("微软雅黑", Font.PLAIN, 18);
    private Font f3 = new Font("微软雅黑", Font.PLAIN, 22);
    private Font f4 = new Font("微软雅黑",Font.PLAIN,16);
    //构造方法
    public Boundary() {
        //创建一个窗口
        setTitle("2016 1.4-10.28 汇添富移动互联股票型基金 收益计算");//窗口标题
        setSize(365, 410);//窗口大小
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
        JLabel chosehour=new JLabel("时");

        jl1.setFont(f2);
        chosemonth.setFont(f2);
        choseday.setFont(f2);
        chosehour.setFont(f2);

        JComboBox buymonthchooser = new JComboBox();
        JComboBox buydaychooser = new JComboBox();
        JComboBox buyhourchooser=new JComboBox();

        for (int i = 1; i <= 10; i++)
            buymonthchooser.addItem(i);
        for (int i = 1; i <= 31; i++)
            buydaychooser.addItem(i);
        for(int i=0;i<=23;i++)
            buyhourchooser.addItem(i);

        jp1.add(jl1);
        jp1.add(buymonthchooser);
        jp1.add(chosemonth);
        jp1.add(buydaychooser);
        jp1.add(choseday);
        jp1.add(buyhourchooser);
        jp1.add(chosehour);

        //panel2
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("卖出时间：");
        JLabel chosemonth2 = new JLabel("月");
        JLabel choseday2 = new JLabel("日");
        JLabel chosehour2=new JLabel("时");

        jl2.setFont(f2);
        chosemonth2.setFont(f2);
        choseday2.setFont(f2);
        chosehour2.setFont(f2);

        JComboBox sellmonthchooser = new JComboBox();
        JComboBox selldaychooser = new JComboBox();
        JComboBox sellhourchooser=new JComboBox();

        for (int i = 1; i <= 10; i++)
            sellmonthchooser.addItem(i);
        for (int i = 1; i <= 31; i++)
            selldaychooser.addItem(i);
        for(int i=0;i<=23;i++)
            sellhourchooser.addItem(i);

        jp2.add(jl2);
        jp2.add(sellmonthchooser);
        jp2.add(chosemonth2);
        jp2.add(selldaychooser);
        jp2.add(choseday2);
        jp2.add(sellhourchooser);
        jp2.add(chosehour2);

        //panel3
        JPanel jp3 = new JPanel();
        JButton sure = new JButton("计算");
        sure.setPreferredSize(new Dimension(80, 50));
        jp3.add(sure);

        //panel5
        JPanel jp5=new JPanel();
        JTextField jt=new JTextField("请输入金额");
        jt.setFont(f2);
        jt.setColumns(10);
        jt.addMouseListener(new MouseAdapter() {//单击清空文本框内容
            public void mouseClicked(MouseEvent e) {
                jt.setText("");
            }
        });
        jt.addKeyListener(new KeyAdapter() {//屏蔽金额的非法输入
        public void keyTyped(KeyEvent e){
            int keyChar=e.getKeyChar();
            if(!(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)){
                e.consume();
            }
        }
        });
        jp5.add(jt);

        //panel4
        JPanel jp4 = new JPanel();
        jp4.setLayout(new GridLayout(5, 1));
        jp4.add(jp0);
        jp4.add(jp1);
        jp4.add(jp2);
        jp4.add(jp5);
        jp4.add(jp3);

        add(jp4);
        setVisible(true);//可视化

        //按计算弹出计算结果
        sure.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame result = new JFrame("计算结果");
                        result.setBounds(650,300,315, 370);
                        //panel ex1
                        JPanel jpex1=new JPanel();
                        JLabel jlex1= null;
                        try {
                            int bmon=buymonthchooser.getSelectedIndex()+1;
                            int bday=buydaychooser.getSelectedIndex()+1;
                            if(buyhourchooser.getSelectedIndex()>15){
                                if (Count.lastday(bmon,bday)){
                                    bmon++;
                                    bday=1;
                                }
                                else {
                                    bday++;
                                }
                            }
                            int smon=sellmonthchooser.getSelectedIndex()+1;
                            int sday=selldaychooser.getSelectedIndex()+1;
                            if(sellhourchooser.getSelectedIndex()>15){
                                if(Count.lastday(smon,sday)){
                                    smon++;
                                    sday=1;
                                }
                                else{
                                    sday++;
                                }
                            }

                            String[] buyinfo=Count.search(bmon+"-"+bday).split("-|@@");
                            String[] sellinfo=Count.search(smon+"-"+sday).split("-|@@");
                            bmon=Integer.parseInt(buyinfo[0]);
                            bday=Integer.parseInt(buyinfo[1]);
                            smon=Integer.parseInt(sellinfo[0]);
                            sday=Integer.parseInt(sellinfo[1]);

                            if(jt.getText().equals("请输入金额")||jt.getText().equals("")||Integer.parseInt(jt.getText())==0){
                                jlex1=new JLabel("请输入金额！",JLabel.CENTER);
                            }
                            else if(!Count.legal(bmon,bday,smon,sday)){
                                jlex1=new JLabel("日期输入错误请重新输入！",JLabel.CENTER);
                            }
                            else{
                                int money=Integer.parseInt(jt.getText());
                                JLabel jlex2=new JLabel("<html><body>"
                                        +"持有"+Count.interval(bmon,bday,smon,sday)+"天"+"<br>"+"<br>"
                                        +"买入费率："+Count.buyrate(money)+"<br>"
                                        +bmon+"月"+bday+"日"+"买入净值:"+buyinfo[2]+"<br>"+"<br>"
                                        +"卖出费率："+Count.sellrate(Count.interval(bmon,bday,smon,sday))+"<br>"
                                        +smon+"月"+sday+"日"+"卖出净值:"+sellinfo[2]
                                        +"<body></html>",JLabel.CENTER);
                                jlex1 = new JLabel("净赚" + String.format("%.2f",
                                        Count.count(bmon, bday, smon, sday, money)) + "元"
                                        ,JLabel.CENTER);
                                jlex2.setFont(f2);
                                jpex1.add(jlex2);
                                jpex1.setLayout(new GridLayout(2,1));
                            }
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                        jlex1.setFont(f3);
                        jpex1.add(jlex1);
                        result.add(jpex1);

                        result.setVisible(true);
                    }
                }
        );
    }

    public static void main(String[] args) {
        new Boundary();
    }
}
