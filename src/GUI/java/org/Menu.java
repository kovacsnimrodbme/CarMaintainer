package GUI.java.org;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * This class is responsible for the menu at the left, and to call the functions of the program.
 */
public class Menu extends javax.swing.JPanel {
    /**
     * An invisible panel, to make clickable menu at the left.
     */
    private final JPanel menuPanel0;
    /**
     * An invisible panel, to make clickable menu at the left.
     */
    private final JPanel menuPanel1;
    /**
     * An invisible panel, to make clickable menu at the left.
     */
    private final JPanel menuPanel2;
    /**
     * An invisible panel, to make clickable menu at the left.
     */
    private final JPanel menuPanel3;
    /**
     * An invisible panel, to make clickable menu at the left.
     */
    private final JPanel menuPanel4;
    /**
     * The field of the GUI_Init, this way the data is accessible in other functions.
     */
    private final GUI_Init gui;

    /**
     * The constructor for the class.
     *
     * @param gui This field is set by outside.
     */
    public Menu(GUI_Init gui) {
        this.gui = gui;
        setOpaque(false);
        setSize(190, 600);
        setLocation(0, 0);

        menuPanel0 = new JPanel();
        menuPanel1 = new JPanel();
        menuPanel2 = new JPanel();
        menuPanel3 = new JPanel();
        menuPanel4 = new JPanel();

        menuPanel0.setSize(new Dimension(190, 90));
        menuPanel1.setSize(new Dimension(190, 70));
        menuPanel2.setSize(new Dimension(190, 70));
        menuPanel3.setSize(new Dimension(190, 70));
        menuPanel4.setSize(new Dimension(190, 70));

        menuPanel0.setLocation(0, 0);
        menuPanel1.setLocation(0, 120);
        menuPanel2.setLocation(0, 190);
        menuPanel3.setLocation(0, 260);
        menuPanel4.setLocation(0, 330);

        menuPanel0.setOpaque(false);
        menuPanel1.setOpaque(false);
        menuPanel2.setOpaque(false);
        menuPanel3.setOpaque(false);
        menuPanel4.setOpaque(false);

        menuPanel0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.setPanel(Panels.menu());
                super.mouseClicked(e);
            }
        });
        menuPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.setPanel(Panels.addService(gui.getData()));
                super.mouseClicked(e);
            }
        });
        menuPanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.setPanel(Panels.seeService(gui.getData()));
                super.mousePressed(e);
            }
        });
        menuPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.setPanel(Panels.addCar(gui.getData()));
                super.mousePressed(e);
            }
        });
        menuPanel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.setPanel(Panels.delCar(gui));
                super.mousePressed(e);
            }
        });
        gui.getFrame().add(menuPanel0);
        gui.getFrame().add(menuPanel1);
        gui.getFrame().add(menuPanel2);
        gui.getFrame().add(menuPanel3);
        gui.getFrame().add(menuPanel4);
    }

    /**
     * The function for the graphics of the menu.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gr = new GradientPaint(0, 0, Color.decode("#00F260"), 0, getHeight(), Color.decode("#0575E6"));
        graphics2D.setPaint(gr);
        graphics2D.fillRect(0, 0, 190, getHeight());

        graphics2D.setFont(new Font("Agency Fb", Font.BOLD, 34));
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString("CarMaintainer", 15, 50);

        try {
            Image image = ImageIO.read(new File("icons/repair.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            Image image2 = ImageIO.read(new File("icons/ser.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            Image image3 = ImageIO.read(new File("icons/new.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            Image image4 = ImageIO.read(new File("icons/del.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);

            graphics2D.drawImage(image, 10, 130, this);
            graphics2D.drawImage(image2, 10, 200, this);
            graphics2D.drawImage(image3, 10, 270, this);
            graphics2D.drawImage(image4, 10, 340, this);

            graphics2D.setFont(new Font("Agency Fb", Font.BOLD, 24));

            graphics2D.drawString("Add service", 65, 160);
            graphics2D.drawString("Services", 65, 230);
            graphics2D.drawString("Add new car", 65, 300);
            graphics2D.drawString("Delete car", 65, 370);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.paintComponent(g);
    }
}