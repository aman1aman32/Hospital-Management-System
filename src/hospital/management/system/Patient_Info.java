package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Patient_Info extends JFrame {

    JTable table;
    JButton b1;

    Patient_Info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 390);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JLabel heading = new JLabel("ALL PATIENT INFORMATION");
        heading.setBounds(220, 10, 260, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(heading);

        JLabel label1 = new JLabel("ID");
        label1.setBounds(15, 45, 50, 15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(85, 45, 70, 15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(165, 45, 60, 15);
        label3.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(240, 45, 60, 15);
        label4.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(315, 45, 70, 15);
        label5.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label5);

        JLabel label6 = new JLabel("Room");
        label6.setBounds(405, 45, 60, 15);
        label6.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(485, 45, 60, 15);
        label7.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label7);

        JLabel label8 = new JLabel("Deposit");
        label8.setBounds(590, 45, 70, 15);
        label8.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label8);

        table = new JTable();
        table.setBounds(10, 70, 670, 220);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel.add(table);

        try {

            conn c = new conn();

            String q = "select * from patient_info";

            ResultSet resultSet = c.statement.executeQuery(q);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("BACK");
        b1.setBounds(280, 320, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
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
        new Patient_Info();
    }
}