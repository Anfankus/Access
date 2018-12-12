package UI;

import javax.swing.*;

public class studentCoures {
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    protected JLabel studentid;
    protected JLabel studentname;
    protected JLabel studentclass;
    protected JLabel studentdept;
    protected JLabel studentcoures;
    protected JLabel label6;
    protected JLabel studentteacher;

    public studentCoures(){
        JFrame frame = new JFrame("查询学生选课信息");
        frame.setContentPane(panel1);
        frame.setBounds(100,100,600,500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
