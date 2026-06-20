package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel heading = new JLabel("SEARCH ROOM");
        heading.setBounds(240, 10, 220, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        JLabel status = new JLabel("Status");
        status.setBounds(50, 73, 120, 20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23, 140, 150, 20);
        Roomno.setForeground(Color.WHITE);
        Roomno.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Roomno);

        JLabel Available = new JLabel("Availability");
        Available.setBounds(175, 140, 150, 20);
        Available.setForeground(Color.WHITE);
        Available.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Available);

        JLabel Clean = new JLabel("Cleaning Status");
        Clean.setBounds(350, 140, 150, 20);
        Clean.setForeground(Color.WHITE);
        Clean.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Clean);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(520, 140, 150, 20);
        Bed.setForeground(Color.WHITE);
        Bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Bed);

        table = new JTable();
        table.setBounds(0, 170, 690, 140);
        table.setBackground(new Color(90, 156, 163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton Search = new JButton("Search");
        Search.setBounds(180, 340, 120, 25);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        panel.add(Search);

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String q = "select * from room where Availability = '"
                        + choice.getSelectedItem() + "'";

                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(380, 340, 120, 25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);

        Back.addActionListener(new ActionListener() {
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
        new SearchRoom();
    }
}