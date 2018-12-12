package UI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class home {
    private JButton buttonIntroduce;
    private JButton buttonCoures;
    private JButton buttonInfo;
    private JButton buttonCount;
    private JButton buttonAdmin;
    private JLabel labelIntroduce;
    private JPanel jpanel2;
    private JPanel jpanel1;
    private JLabel labelFunction;
    private JLabel introduce;
    private JLabel function1;
    private JLabel function2;
    private Boolean isAdmin;

    public home(boolean ia){
        isAdmin = ia;
        JFrame frame = new JFrame("大学数据库查询系统");
        frame.setContentPane(jpanel1);
        frame.setVisible(true);
        frame.setBounds(100,100,650,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonCoures.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Coures coures = new Coures();
            }
        });
        buttonInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                userInfo ui = new userInfo();
            }
        });
        buttonCount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Dept dept = new Dept();
            }
        });


        buttonAdmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(isAdmin){
                    Admin admin = new Admin();
                }else {
                    Information info = new Information();
                    info.label.setText("没有权限");
                }
            }
        });
    }
}
