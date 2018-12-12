package UI;

import javax.swing.*;

public class studentInfo {
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    protected JLabel sid;
    protected JLabel sname;
    protected JLabel sex;
    protected JLabel age;
    protected JLabel year;
    protected JLabel gpa;

    public studentInfo(){
        JFrame frame = new JFrame("查询学生基本信息");
        frame.setContentPane(panel1);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100,100,600,500);
    }

}
