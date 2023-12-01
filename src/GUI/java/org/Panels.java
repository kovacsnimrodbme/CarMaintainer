package GUI.java.org;

import IO.java.org.Car;
import IO.java.org.Data;
import IO.java.org.Service;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import com.github.lgooddatepicker.components.*;

public class Panels {
    public static JPanel menu() {
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(610, 600));
        panel.setLocation(190, 0);
        panel.setBorder(new EmptyBorder(0, 200, 0, 0));
        return panel;
    }

    public static JPanel addService(Data data) {
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(610, 600));
        panel.setLocation(190, 0);
        panel.setBorder(new EmptyBorder(10, 270, 50, 80));

        Font font = new Font("Agency Fb", Font.BOLD, 20);

        if (data.getCarList().isEmpty()) {
            panel.setLayout(new FlowLayout());
            JLabel ld = new JLabel("There isn't any car in the program!");
            ld.setFont(font);
            panel.add(ld);
        } else {

            GridBagLayout layout = new GridBagLayout();
            panel.setLayout(layout);

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(5, 5, 5, 5);

            JLabel l = new JLabel("Add a new service");
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setFont(new Font("Agency Fb", Font.BOLD, 32));
            JLabel l1 = new JLabel("Part name");
            l1.setHorizontalAlignment(JLabel.CENTER);
            l1.setFont(font);
            JLabel l2 = new JLabel("Part number(optional)");
            l2.setHorizontalAlignment(JLabel.CENTER);
            l2.setFont(font);
            JLabel l3 = new JLabel("Price:");
            l3.setHorizontalAlignment(JLabel.CENTER);
            l3.setFont(font);

            JComboBox<String> selector = new JComboBox<>(data.getCarListVector());
            selector.setFont(font);

            DatePicker date = new DatePicker();
            DefaultTableModel model = new DefaultTableModel(new String[]{"", ""}, 1);
            JTable parts = new JTable(model);
            parts.setRowHeight(25);
            parts.setTableHeader(null);
            JScrollPane scroll = new JScrollPane(parts);

            JTextField price = new JTextField(10);

            JButton addRow = new JButton("Add row");
            addRow.addActionListener(e -> model.addRow(new String[]{"", ""}));
            addRow.setFont(font);
            JButton delRow = new JButton("Delete row");
            delRow.addActionListener(e -> {
                if (parts.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(new JFrame(), "No row selected!", "Alert", JOptionPane.WARNING_MESSAGE);
                } else {
                    model.removeRow(parts.getSelectedRow());
                }
            });
            delRow.setFont(font);

            JButton createSer = new JButton("Create");
            createSer.addActionListener(e -> {
                if (date.getDate() == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid date!", "Alert", JOptionPane.WARNING_MESSAGE);
                } else {
                    int num = Integer.MIN_VALUE;
                    boolean exc = false;
                    try {
                        num = Integer.parseInt(price.getText());
                    } catch (NumberFormatException e1) {
                        exc = true;
                    }
                    if (exc || 0 > num) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid price!", "Alert", JOptionPane.WARNING_MESSAGE);
                    } else {
                        boolean empty = false;
                        ArrayList<String> partsArray = new ArrayList<>();
                        ArrayList<String> partNumsArray = new ArrayList<>();
                        for (int i = 0; i < model.getRowCount(); i++) {
                            partsArray.add((String) model.getValueAt(i, 0));
                            partNumsArray.add((String) model.getValueAt(i, 1));
                            if (model.getValueAt(i, 0) == null) {
                                empty = true;
                            } else if (model.getValueAt(i, 0).hashCode() == 0) {
                                empty = true;
                            }
                        }
                        if (empty) {
                            JOptionPane.showMessageDialog(new JFrame(), "Some rows are empty!", "Alert", JOptionPane.WARNING_MESSAGE);
                        } else {
                            data.getCarByName((String) selector.getSelectedItem()).addService(new Service(date.getDate(), num, partsArray, partNumsArray));
                            JOptionPane.showMessageDialog(new JFrame(), "Successfully added the service!");
                        }
                    }
                }
            });
            createSer.setFont(font);

            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            panel.add(l, c);
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 1;
            panel.add(selector, c);
            c.gridx = 1;
            c.gridy = 1;
            panel.add(date, c);
            c.gridx = 0;
            c.gridy = 2;
            panel.add(l1, c);
            c.gridx = 1;
            c.gridy = 2;
            panel.add(l2, c);
            c.gridx = 0;
            c.gridy = 3;
            c.gridwidth = 2;
            c.gridheight = 6;
            c.weighty = 1;
            c.weightx = 1;
            panel.add(scroll, c);
            c.gridx = 0;
            c.gridy = 9;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.weighty = 0;
            panel.add(addRow, c);
            c.gridx = 1;
            c.gridy = 9;
            panel.add(delRow, c);
            c.gridx = 0;
            c.gridy = 10;
            panel.add(l3, c);
            c.gridx = 1;
            c.gridy = 10;
            panel.add(price, c);
            c.gridx = 0;
            c.gridy = 12;
            c.gridwidth = 2;
            panel.add(createSer, c);
        }


        return panel;
    }

    public static JPanel seeService(Data data) {
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(610, 600));
        panel.setLocation(190, 0);
        panel.setBorder(new EmptyBorder(10, 270, 50, 80));
        Font font = new Font("Agency Fb", Font.BOLD, 20);

        if (data.getCarList().isEmpty()) {
            panel.setLayout(new FlowLayout());
            JLabel ld = new JLabel("There isn't any car in the program!");
            ld.setFont(font);
            panel.add(ld);
        } else {

            GridBagLayout layout = new GridBagLayout();
            panel.setLayout(layout);

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.BOTH;
            c.insets = new Insets(20, 5, 10, 5);

            JLabel l = new JLabel("Service history");
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setFont(new Font("Agency Fb", Font.BOLD, 32));

            JComboBox<String> selector = new JComboBox<>(data.getCarListVector());
            selector.setFont(font);

            DefaultTableModel model = new DefaultTableModel(new String[]{"etwas", "frisch"}, 0);
            JTable serviceTable = new JTable(model);
            serviceTable.setTableHeader(null);
            serviceTable.setDefaultEditor(Object.class, null);
            serviceTable.setRowHeight(25);

            selector.addActionListener(e -> {
                while (0 < model.getRowCount()) {
                    model.removeRow(0);
                }
                if (data.getCarByName((String) selector.getSelectedItem()).getServices().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "The chosen car does not have a service history!", "Alert", JOptionPane.WARNING_MESSAGE);
                } else {
                    Car car = data.getCarByName((String) selector.getSelectedItem());
                    for (int i = 0; i < car.getServices().size(); i++) {
                        model.addRow(new String[]{i + 1 + ". service", "Date: " + car.getServices().get(i).getDate()});
                        for (int j = 0; j < car.getServices().get(i).getPartSize(); j++) {
                            model.addRow(car.getServices().get(i).getPartsByRow(j));
                        }
                        model.addRow(new String[]{"Price:", car.getServices().get(i).getPrice() + " Ft"});
                    }
                }
            });

            c.gridx = 0;
            c.gridy = 0;
            panel.add(l, c);
            c.gridx = 0;
            c.gridy = 1;
            panel.add(selector, c);
            c.gridx = 0;
            c.gridy = 2;
            c.weighty = 0.1;
            c.weightx = 0.1;
            JScrollPane scroll = new JScrollPane(serviceTable);
            panel.add(scroll, c);
        }
        return panel;
    }

    public static JPanel addCar(Data data) {
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(610, 600));
        panel.setLocation(190, 0);
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 200, 10, 10));

        Font font = new Font("Agency Fb", Font.BOLD, 20);

        JLabel l = new JLabel("Add a new car");
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setFont(new Font("Agency Fb", Font.BOLD, 32));

        JLabel l1 = new JLabel("Make:");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(font);
        JLabel l2 = new JLabel("Type:");
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setFont(font);
        JLabel l3 = new JLabel("VIN:");
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setFont(font);

        JTextField t1 = new JTextField(20);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFont(font);
        JTextField t2 = new JTextField(20);
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setFont(font);
        JTextField t4 = new JTextField(17);
        t4.setHorizontalAlignment(JTextField.CENTER);
        t4.setFont(font);

        JButton b1 = new JButton("Add");
        b1.setFont(font);
        b1.addActionListener(e -> {
            if (t1.getText().isEmpty() || t2.getText().isEmpty() || t4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "At least one of the lines are empty!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                data.addCar(new Car(t1.getText(), t2.getText(), t4.getText()));
                JOptionPane.showMessageDialog(new JFrame(), "Successfully added the car!");

            }
        });

        panel.add(l);
        panel.add(new JLabel());
        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(l3);
        panel.add(t4);
        panel.add(b1);
        return panel;
    }

    public static JPanel delCar(Data data) {
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(610, 600));
        panel.setLocation(190, 0);
        panel.setBorder(new EmptyBorder(10, 200, 10, 10));

        Font font = new Font("Agency Fb", Font.BOLD, 20);

        if (data.getCarList().isEmpty()) {
            panel.setLayout(new FlowLayout());
            JLabel ld = new JLabel("There isn't any car in the program!");
            ld.setFont(font);
            panel.add(ld);
        } else {
            panel.setLayout(new GridLayout(6, 2, 10, 10));
            final JComboBox[] selector = new JComboBox[]{new JComboBox<>(data.getCarListVector())};
            selector[0].setFont(font);

            final Car[] car = {new Car()};

            JLabel l = new JLabel("Delete a car");
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setFont(new Font("Agency Fb", Font.BOLD, 32));

            JLabel l1 = new JLabel("Make:");
            l1.setHorizontalAlignment(JLabel.CENTER);
            l1.setFont(font);
            JLabel l2 = new JLabel("Type:");
            l2.setHorizontalAlignment(JLabel.CENTER);
            l2.setFont(font);
            JLabel l3 = new JLabel("VIN:");
            l3.setHorizontalAlignment(JLabel.CENTER);
            l3.setFont(font);
            JLabel l4 = new JLabel("Number of stored services:");
            l4.setHorizontalAlignment(JLabel.CENTER);
            l4.setFont(font);

            JLabel l11 = new JLabel();
            l11.setHorizontalAlignment(JTextField.CENTER);
            l11.setFont(font);
            JLabel l21 = new JLabel();
            l21.setHorizontalAlignment(JTextField.CENTER);
            l21.setFont(font);
            JLabel l31 = new JLabel();
            l31.setHorizontalAlignment(JTextField.CENTER);
            l31.setFont(font);
            JLabel l41 = new JLabel();
            l41.setHorizontalAlignment(JTextField.CENTER);
            l41.setFont(font);

            JButton b1 = new JButton("Delete");
            b1.setFont(font);

            selector[0].addActionListener(e -> {
                car[0] = data.getCarByName((String) selector[0].getSelectedItem());
                l11.setText(car[0].getMake());
                l21.setText(car[0].getType());
                l31.setText(car[0].getVin());
                l41.setText(String.valueOf((car[0].getServices().size())));
            });

            b1.addActionListener(e -> {
                Car carToDel = car[0];
                if (JOptionPane.showConfirmDialog(new JFrame(),
                        "Are you sure?", "Delete the car", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    if (selector[0].getSelectedIndex() == 0) {
                        selector[0].setSelectedIndex(1);
                        selector[0].removeItemAt(0);
                    } else {
                        int j = selector[0].getSelectedIndex();
                        selector[0].setSelectedIndex(0);
                        selector[0].removeItemAt(j);
                    }
                    data.deleteCar(carToDel);
                    panel.setVisible(true);
                }
            });

            panel.add(l);
            panel.add(selector[0]);
            panel.add(l1);
            panel.add(l11);
            panel.add(l2);
            panel.add(l21);
            panel.add(l3);
            panel.add(l31);
            panel.add(l4);
            panel.add(l41);
            panel.add(b1);
        }
        return panel;
    }
}
