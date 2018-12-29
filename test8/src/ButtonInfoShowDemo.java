import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonInfoShowDemo extends JFrame {
    public ButtonInfoShowDemo() {
        setSize(300, 100);
        setLocationRelativeTo(null);//窗口显示在屏幕中间
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭方式
        JTextField jt = new JTextField(20);
        JButton jb1 = new JButton("b1");
        JButton jb2 = new JButton("b2");
        JPanel jp=new JPanel();
        jb1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jt.setText("按了b1");
                    }
                }
        );

        jb2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jt.setText("按了b2");
                    }
                }
        );

        jp.add(jb1);
        jp.add(jb2);
        jp.add(jt);

        add(jp);
        setVisible(true);
    }

    public static void main(String[] args) {
        ButtonInfoShowDemo sample = new ButtonInfoShowDemo();
    }
}
