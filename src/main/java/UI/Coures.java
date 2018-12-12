package UI;

import Dao.CustomerDao;
import Model.Enroll;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;

public class Coures {
    private JTextField textField1;
    private JButton Button1;
    private JButton Button2;
    private JLabel label1;
    private JPanel panel;
    private Connection conn;

    public Coures(){
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,300,200);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int sid = Integer.parseInt(textField1.getText());
                CustomerDao c=new CustomerDao(conn);
                Enroll x=c.queryStudentEnroll(sid);
                studentCoures sc = new studentCoures();

                sc.studentid.setText(sid+"");
                sc.studentname.setText(x.getSname());
                sc.studentclass.setText(x.getSectno());
                sc.studentdept.setText(x.getDname());
                sc.studentcoures.setText(x.getCname());
                sc.studentteacher.setText(x.getPname());
            }
        });
    }
    public void init() throws Exception{
        conn= DriverManager.getConnection(
                "jdbc:ucanaccess://university.accdb");
    }
}
