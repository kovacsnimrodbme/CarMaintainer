package GUI.java.org;

import javax.swing.*;
import java.awt.*;

public class Panels {
    public static JPanel menu() {
        JPanel panel=new JPanel();
        panel.setSize(610,600);
        panel.setLocation(190, 0);
        return panel;
    }

    public static JPanel addService() {
        JPanel panel = new JPanel();
        panel.setSize(610,600);
        panel.setLocation(190, 0);
        JLabel l = new JLabel("addService");
        panel.add(l);
        return panel;
    }

    public static JPanel seeService() {
        JPanel panel = new JPanel();
        panel.setSize(610,600);
        panel.setLocation(190, 0);
        JLabel l = new JLabel("seeService");
        panel.add(l);
        return panel;
    }

    public static JPanel addCar() {

        JLabel l = new JLabel("Make:");
        JLabel l1 = new JLabel("Type:");
        JLabel l2 = new JLabel("Engine code:");
        JLabel l3 = new JLabel("VIN:");

        JTextField t1 = new JTextField(20);
        JTextField t2 = new JTextField(20);
        JTextField t3 = new JTextField(20);
        JTextField t4 = new JTextField(17);

        JPanel panel = new JPanel();
        panel.setSize(610,600);
        panel.setLocation(190, 0);
        panel.setLayout(new GridLayout(5,3));

        panel.add(new JLabel());
        panel.add(l);
        panel.add(t1);
        panel.add(new JLabel());
        panel.add(l1);
        panel.add(t2);
        panel.add(new JLabel());
        panel.add(l2);
        panel.add(t3);
        panel.add(new JLabel());
        panel.add(l3);
        panel.add(t4);
        return panel;
    }

    public static JPanel delCar() {
        JPanel panel = new JPanel();
        panel.setSize(610,600);
        panel.setLocation(190, 0);
        JLabel l = new JLabel("delcar");
        panel.add(l);
        return panel;
    }
}
