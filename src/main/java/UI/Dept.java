package UI;

import Dao.CustomerDao;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class Dept {
    private JTextField textField1;
    private JButton Button1;
    private JButton Button2;
    private JPanel panel;
    private JLabel label;
    private Connection conn;

    public Dept(){
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setBounds(100,100,300,300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        Button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    init();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                String dc = textField1.getText();
                CustomerDao dao = new CustomerDao(conn);
                Map x = dao.queryDeptCount(dc);
                Object[] top = {"院系","人数"};
                String[][] ob = new String[x.size()][2];
                int a = 0;
                for (Object key:x.keySet()){
                    ob[a][0]= String.valueOf(key);
                    ob[a][1]= String.valueOf(x.get(key));
                    a++;
                }
                numOfDept nod = new numOfDept();
                if(x.size()==1){
                    nod.label1.setText(ob[0][0]);
                    nod.label11.setText(ob[0][1]);
                }else{
                    nod.label1.setText(ob[0][0]);
                    nod.label11.setText(ob[0][1]);
                    nod.label2.setText(ob[1][0]);
                    nod.label22.setText(ob[1][1]);
                    nod.label3.setText(ob[2][0]);
                    nod.label33.setText(ob[2][1]);
                    nod.label4.setText(ob[3][0]);
                    nod.label44.setText(ob[3][1]);
                    nod.label5.setText(ob[4][0]);
                    nod.label55.setText(ob[4][1]);
                    nod.label6.setText(ob[5][0]);
                    nod.label66.setText(ob[5][1]);
                }

            }
        });
    }
    public void init() throws Exception{
        conn= DriverManager.getConnection(
                "jdbc:ucanaccess://university.accdb");
    }
}
