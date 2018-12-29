import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginApp extends JFrame {
    public UserLoginApp() {
        setSize(200, 200);
        setLocationRelativeTo(null);//窗口显示在屏幕中间
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭方式
        setTitle("用户登录");

        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("用户类型");
        String[] user = {"学生用户", "教师用户"};
        JComboBox jc = new JComboBox(user);
        jp1.add(jl1);
        jp1.add(jc);

        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("用户名：");
        JTextField jt1 = new JTextField();
        jt1.setColumns(7);
        jp2.add(jl2);
        jp2.add(jt1);

        JPanel jp3 = new JPanel();
        JLabel jl3 = new JLabel("密 码： ");
        JTextField jt2 = new JTextField();
        jp3.add(jl3);
        jt2.setColumns(7);
        jp3.add(jt2);

        JPanel jp4 = new JPanel();
        jp4.add(jp1);
        jp4.add(jp2);
        jp4.add(jp3);

        JPanel jp5 = new JPanel();
        JButton jb1 = new JButton("确定");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame result = new JFrame();
                result.setSize(180, 150);

                JLabel info = new JLabel();
                if (jt1.getText().equals("")) {
                    info.setText("用户名不可为空!");
                } else if (jt2.getText().equals("")) {
                    info.setText("密码不可为空!");
                } else if (jc.getSelectedIndex() == 0 && jt1.getText().equals("s") && jt2.getText().equals("s")) {
                    info.setText("学生用户登陆成功");
                } else if (jc.getSelectedIndex() == 1 && jt1.getText().equals("t") && jt2.getText().equals("t")) {
                    info.setText("教师用户登陆成功");
                } else {
                    info.setText("用户名不存在或者密码不正确!");
                }

                result.add(info);
                result.setVisible(true);
                result.setLocationRelativeTo(null);
            }
        });

        JButton jb2 = new JButton("取消");
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt1.setText("");
                jt2.setText("");
            }
        });

        JButton jb3 = new JButton("退出");
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jp5.add(jb1);
        jp5.add(jb2);
        jp5.add(jb3);

        jp4.add(jp5);

        add(jp4);
        setVisible(true);

    }

    public static void main(String[] args) {
        UserLoginApp sample = new UserLoginApp();
    }
}
