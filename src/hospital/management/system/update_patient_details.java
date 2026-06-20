package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(450, 80, 180, 180);
        panel.add(imageLabel);

        JLabel heading = new JLabel("Update Patient Details");
        heading.setBounds(170, 15, 260, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25, 70, 100, 14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(180, 67, 140, 25);
        panel.add(choice);

        try {
            conn c = new conn();

            ResultSet resultSet =
                    c.statement.executeQuery("select * from Patient_Info");

            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25, 110, 120, 14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(180, 107, 140, 20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25, 150, 100, 14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(180, 147, 140, 20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(25, 190, 120, 14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(180, 187, 140, 20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount :");
        label6.setBounds(25, 230, 140, 14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(180, 227, 140, 20);
        textFieldPending.setEditable(false);
        panel.add(textFieldPending);

        JButton update = new JButton("UPDATE");
        update.setBounds(70, 310, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);

        JButton back = new JButton("BACK");
        back.setBounds(200, 310, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        JButton check = new JButton("CHECK");
        check.setBounds(330, 310, 100, 25);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = choice.getSelectedItem();

                try {

                    conn c = new conn();

                    String q = "select * from Patient_Info where Name = '" + id + "'";

                    ResultSet resultSet = c.statement.executeQuery(q);

                    while (resultSet.next()) {

                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery(
                            "select * from room where room_no = '" +
                                    textFieldR.getText() + "'");

                    while (resultSet1.next()) {

                        String price = resultSet1.getString("Price");

                        int pending =
                                Integer.parseInt(price) -
                                        Integer.parseInt(textFieldAmount.getText());

                        textFieldPending.setText("" + pending);
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    conn c = new conn();

                    String name = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();

                    String q =
                            "update Patient_Info set Room_Number='" + room +
                                    "', Time='" + time +
                                    "', Deposite='" + amount +
                                    "' where Name='" + name + "'";

                    c.statement.executeUpdate(q);

                    JOptionPane.showMessageDialog(
                            null,
                            "Updated Successfully");

                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(700, 400);
        setLocation(310, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }
}