package UI;

import Dao.CustomerDao;
import Model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;

public class userInfo {
    private JTextField textField1;
    private JButton Button1;
    private JButton Button2;
    private JPanel panel;
    private JLabel label;
    private Connection conn;



    public userInfo() {

        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setBounds(100,100,300,300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        Button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    init();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                int sid = Integer.parseInt(textField1.getText());
                CustomerDao dao = new CustomerDao(conn);
                Student s = dao.queryStudentInfo(sid);
                studentInfo si = new studentInfo();
                si.sid.setText(s.getSid());
                si.sname.setText(s.getSname());
                si.sex.setText(String.valueOf(s.getSex()));
                si.age.setText(String.valueOf(s.getAge()));
                si.year.setText(String.valueOf(s.getYear()));
                si.gpa.setText(String.valueOf(s.getGpa()));
            }
        });
    }
    public void init() throws Exception{
        conn= DriverManager.getConnection(
                "jdbc:ucanaccess://university.accdb");
    }
}
