package UI;

import Dao.AdminDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;


public class login {
    private JTextField textField1;
    private JButton buttonRegister;
    private JButton buttonLogin;
    private JButton buttonNoman;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private Connection conn;

    public login(){
        JFrame frame = new JFrame("登录");
        buttonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonNoman.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.setContentPane(panel1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,300,150);

        buttonRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    init();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                String uid = textField1.getText();
                String pwd = String.valueOf(passwordField1.getPassword());
                AdminDao dao = new AdminDao(conn);
                Information info = new Information();
                if(dao.createNewAccount(uid,pwd)){
                    info.label.setText("新用户创建成功！");
                }else{
                    info.label.setText("错误!");
                }


            }
        });
        buttonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    init();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                String uid = textField1.getText();
                String pwd = String.valueOf(passwordField1.getPassword());
                AdminDao dao = new AdminDao(conn);
                if (dao.verify(uid,pwd)){
                    home mainForm = new home(true);
                    frame.setVisible(false);
                }else{
                    Information info = new Information();
                    info.label.setText("错误!");
                }


            }
        });
        buttonNoman.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                home mainForm = new home(false);
                frame.setVisible(false);

            }
        });
    }
    public void init() throws Exception{
        conn= DriverManager.getConnection(
                "jdbc:ucanaccess://university.accdb");

    }
    public static void main(String[] args){
        login newFrame = new login();
    }
}
