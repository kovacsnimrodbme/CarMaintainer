package GUI.java.org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Init {
    public JFrame frame = new JFrame("CarMaintainer");

    public GUI_Init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage("car_sedan2.png");
        frame.setIconImage(icon);
        frame.add(new Menu(this));
        frame.setVisible(true);
    }

    public void setPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(new Menu(this));
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

