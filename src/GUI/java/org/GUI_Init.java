package GUI.java.org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import IO.java.org.Data;
import IO.java.org.FileIO;

/**
 * The class for the frame, and to change the panels inside it.
 */
public class GUI_Init {
    /**
     * The frame of the application.
     */
    private final JFrame frame;
    /**
     * The data structure for the program.
     */
    private final Data data;

    /**
     * The constructor for the class.
     * It's sets the basics for the frame.
     *
     * @param data The data structure with the data of the cars, the program works with this afterward.
     */
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

    /**
     * This function makes the frame visible (starts the program).
     */
    public void run() {
        frame.setVisible(true);
    }

    /**
     * A getter for the data field.
     *
     * @return It returns the private field data.
     */
    public Data getData() {
        return data;
    }

    /**
     * A getter for the frame.
     *
     * @return It returns the private field frame.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * This function sets the visible panel for the frame.
     *
     * @param panel This panel will be displayed.
     */
    public void setPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(new Menu(this));
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

