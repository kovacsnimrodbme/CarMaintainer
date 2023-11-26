package GUI.java.org;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Menu extends javax.swing.JPanel {
    private JPanel menuPanel0 = new JPanel();
    private JPanel menuPanel1 = new JPanel();
    private JPanel menuPanel2 = new JPanel();
    private JPanel menuPanel3 = new JPanel();
    private JPanel menuPanel4 = new JPanel();
    private GUI_Init gui;

    public Menu(GUI_Init gui) {
        this.gui = gui;
        setOpaque(false);
        setSize(190, 600);
        setLocation(0, 0);
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
                gui.setPanel(Panels.addService());
                super.mouseClicked(e);
            }
        });
        menuPanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.setPanel(Panels.seeService());
                super.mousePressed(e);
            }
        });
        menuPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.setPanel(Panels.addCar());
                super.mousePressed(e);
            }
        });
        menuPanel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gui.setPanel(Panels.delCar());
                super.mousePressed(e);
            }
        });
        gui.frame.add(menuPanel0);
        gui.frame.add(menuPanel1);
        gui.frame.add(menuPanel2);
        gui.frame.add(menuPanel3);
        gui.frame.add(menuPanel4);
    }

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
            Image image = ImageIO.read(new File("repair.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            Image image2 = ImageIO.read(new File("ser.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            Image image3 = ImageIO.read(new File("new.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            Image image4 = ImageIO.read(new File("del.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
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