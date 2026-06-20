package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Employee_Info extends JFrame {

    JTable table;
    JButton back;

    Employee_Info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 390);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        JLabel label1 = new JLabel("Name");
        label1.setBounds(20, 10, 80, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(130, 10, 50, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(210, 10, 100, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(350, 10, 80, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(460, 10, 80, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar Number");
        label6.setBounds(560, 10, 120, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label6);

        table = new JTable();
        table.setBounds(10, 40, 670, 250);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(table);

        try {
            conn c = new conn();

            String q = "select * from EMP_INFO";

            ResultSet resultSet = c.statement.executeQuery(q);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBounds(280, 320, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

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
        new Employee_Info();
    }
}