package javalaba;

import javax.swing.*;

public class Jtables {
    JFrame f;
    JTable j; // Corrected JTable spelling

    // Constructor with correct syntax
    Jtables() {
        f = new JFrame();
        f.setTitle("Student Table");

        // Data for the table
        String[][] data = {
                {"Raushan", "101", "CSE"},
                {"Raushani", "102", "BMEE"}
        };

        // Column Names
        String[] columnNames = {"Name", "Roll No", "Department"};

        // Create the JTable with data and column names
        j = new JTable(data, columnNames); // Corrected JTable spelling
        j.setBounds(30, 40, 200, 300);

        // Add the table to a scroll pane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        // Frame properties
        f.setVisible(true);
        f.setSize(500, 200);
    }

    public static void main(String[] args) {
        new Jtables(); // Calling the constructor to create the table
    }
}
