package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame {

    JTable table;
    JButton b1;

    Department() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 390);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JLabel label1 = new JLabel("Department");
        label1.setBounds(120, 11, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(430, 11, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        table = new JTable();
        table.setBounds(0, 40, 690, 250);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(table);

        try {
            conn c = new conn();

            String q = "select * from department";

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
        setSize(700, 400);
        setLayout(null);
        setLocation(310, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}