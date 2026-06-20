package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {

    Choice choice;
    JLabel RNo, INTime, OUTTime;

    patient_discharge() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 390);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JLabel heading = new JLabel("PATIENT DISCHARGE");
        heading.setBounds(220, 20, 250, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(heading);

        JLabel label1 = new JLabel("Patient ID");
        label1.setBounds(30, 80, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);

        try {
            conn c = new conn();

            ResultSet resultSet =
                    c.statement.executeQuery("select * from Patient_Info");

            while (resultSet.next()) {
                choice.add(resultSet.getString("Number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        RNo = new JLabel();
        RNo.setBounds(200, 130, 150, 20);
        RNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30, 180, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        INTime = new JLabel();
        INTime.setBounds(200, 180, 250, 20);
        INTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30, 230, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date = new Date();

        OUTTime = new JLabel("" + date);
        OUTTime.setBounds(200, 230, 300, 20);
        OUTTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        OUTTime.setForeground(Color.WHITE);
        panel.add(OUTTime);

        JButton Check = new JButton("Check");
        Check.setBounds(300, 300, 120, 30);
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        panel.add(Check);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30, 300, 120, 30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);

        JButton Back = new JButton("Back");
        Back.setBounds(160, 300, 120, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    conn c = new conn();

                    ResultSet resultSet =
                            c.statement.executeQuery(
                                    "select * from Patient_Info where Number = '" +
                                            choice.getSelectedItem() + "'");

                    while (resultSet.next()) {

                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    conn c = new conn();

                    c.statement.executeUpdate(
                            "delete from Patient_Info where Number = '" +
                                    choice.getSelectedItem() + "'");

                    c.statement.executeUpdate(
                            "update Room set Availability = 'Available' where room_no = '" +
                                    RNo.getText() + "'");

                    JOptionPane.showMessageDialog(null, "Done");

                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        Back.addActionListener(new ActionListener() {
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
        new patient_discharge();
    }
}