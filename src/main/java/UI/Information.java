package UI;

import javax.swing.*;
import java.awt.*;

public class Information {
    private JPanel panel1;
    protected JLabel label;

    public Information(){
        label.setPreferredSize(new Dimension(200,50));
        JFrame frame = new JFrame("提示");
        frame.setContentPane(panel1);
        frame.setVisible(true);
        frame.setBounds(100,100,100,100);
    }
}
