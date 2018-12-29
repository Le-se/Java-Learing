import javax.swing.*;
import java.awt.event.*;

public class GuessNumber extends JFrame {
    public GuessNumber(){
        setSize(240, 150);
        JPanel jp=new JPanel();
        setLocationRelativeTo(null);//窗口显示在屏幕中间
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭方式
        JLabel jl2=new JLabel();

        int actual=(int)(Math.random()*100);
        JLabel jl=new JLabel("你猜猜这个数是多少？（0~99）");
        JTextField jt=new JTextField();
        jt.setColumns(16);
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jt.setText("");
            }
        });
        jt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int keyChar=e.getKeyChar();
                if(!(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)) {
                    e.consume();
                }
            }
        });

        JButton jb=new JButton("确定");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result="";
                int num=Integer.parseInt(jt.getText());
                if(num<actual){
                    result ="猜太小了";
                }
                else if(num>actual){
                    result ="猜太大了";
                }
                else{
                    result ="恭喜你猜对了";
                }
                jl2.setText(result);
            }
        });

        jp.add(jl);
        jp.add(jt);
        jp.add(jb);
        jp.add(jl2);

        add(jp);
        setVisible(true);
    }

    public static void main(String[] args) {
        GuessNumber sample=new GuessNumber();
    }
}
