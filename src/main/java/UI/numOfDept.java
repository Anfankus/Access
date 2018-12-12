package UI;

import javax.swing.*;

public class numOfDept {
    private JPanel panel1;
    protected JLabel label1;
    protected JLabel label2;
    protected JLabel label3;
    protected JLabel label4;
    protected JLabel label5;
    protected JLabel label6;
    protected JLabel label11;
    protected JLabel label22;
    protected JLabel label33;
    protected JLabel label44;
    protected JLabel label55;
    protected JLabel label66;
    private JLabel label;
    private JLabel label0;

    public numOfDept(){
        JFrame frame = new JFrame("查询院系人数");
        frame.setContentPane(panel1);
        frame.setBounds(100,100,600,500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
