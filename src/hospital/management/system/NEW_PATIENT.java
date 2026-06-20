package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class NEW_PATIENT extends JFrame implements ActionListener{

    JComboBox<String> comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    NEW_PATIENT() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Image
        ImageIcon imageIcon = new ImageIcon(
                ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(
                130, 130, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(500, 120, 130, 130);
        panel.add(imageLabel);

        // Heading
        JLabel heading = new JLabel("NEW PATIENT FORM");
        heading.setBounds(190, 15, 320, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(heading);

        // ID
        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(40, 60, 100, 20);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[]{
                "Aadhar Card",
                "Voter ID",
                "Driving License"
        });
        comboBox.setBounds(180, 60, 160, 25);
        panel.add(comboBox);

        // Number
        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(40, 95, 100, 20);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(180, 95, 160, 25);
        panel.add(textFieldNumber);

        // Name
        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(40, 130, 100, 20);
        labelName.setForeground(Color.WHITE);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelName);

        textName = new JTextField();
        textName.setBounds(180, 130, 160, 25);
        panel.add(textName);

        // Gender
        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(40, 165, 100, 20);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setBounds(180, 165, 70, 20);
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(90, 156, 163));

        r2 = new JRadioButton("Female");
        r2.setBounds(260, 165, 90, 20);
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(90, 156, 163));

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        panel.add(r1);
        panel.add(r2);

        // Disease
        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(40, 200, 100, 20);
        labelDisease.setForeground(Color.WHITE);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(180, 200, 160, 25);
        panel.add(textFieldDisease);

        // Room
        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(40, 235, 100, 20);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelRoom);

        c1 = new Choice();

        try {
            conn c = new conn();

            ResultSet resultSet =
                    c.statement.executeQuery(
                            "select room_no from Room where Availability='Available'");

            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(180, 235, 160, 25);
        panel.add(c1);

        // Time
        JLabel labelTime = new JLabel("Time :");
        labelTime.setBounds(40, 270, 100, 20);
        labelTime.setForeground(Color.WHITE);
        labelTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelTime);

        Date date1 = new Date();

        date = new JLabel("" + date1);
        date.setBounds(180, 270, 280, 20);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        // Deposit
        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(40, 305, 100, 20);
        labelDeposit.setForeground(Color.WHITE);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelDeposit);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(180, 305, 160, 25);
        panel.add(textFieldDeposite);

        // Buttons
        b1 = new JButton("ADD");
        b1.setBounds(140, 345, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(270, 345, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setLayout(null);
        setSize(700, 400);
        setLocation(310, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            conn c = new conn();

            String radioBTN = null;

            if (r1.isSelected()) {
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try {

                String q = "insert into patient_info values('" +
                        s1 + "','" +
                        s2 + "','" +
                        s3 + "','" +
                        s4 + "','" +
                        s5 + "','" +
                        s6 + "','" +
                        s7 + "','" +
                        s8 + "')";

                String q1 = "update Room set Availability = 'Occupied' where room_no = '" + s6 + "'";

                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "Added Successfully");

                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {

            setVisible(false);

        }
    }
}