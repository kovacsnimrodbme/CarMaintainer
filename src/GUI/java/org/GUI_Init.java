package GUI.java.org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import IO.java.org.Data;
import IO.java.org.FileIO;

public class GUI_Init {
    private final JFrame frame;
    private final Data data;

    public GUI_Init(Data data) {
        this.frame = new JFrame("CarMaintainer");
        this.data = data;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage("icons/car_sedan2.png");
        frame.setIconImage(icon);
        frame.add(new Menu(this));
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    FileIO.save(data);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        frame.setVisible(true);
    }

    public Data getData() {
        return data;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(new Menu(this));
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

