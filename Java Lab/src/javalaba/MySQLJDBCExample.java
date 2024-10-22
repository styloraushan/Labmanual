package javalaba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJDBCExample {

    // MySQL Database credentials
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/userdb"; // Replace 'your_database_name'

    // MySQL credentials
    static final String USER = "root"; // Replace 'your_username'
    static final String PASS = "raushanR@123"; // Replace 'your_password'

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Register MySQL JDBC Driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement object to send SQL commands
            stmt = conn.createStatement();

            // Create a table
            String createTableSQL = "CREATE TABLE Employees "
                    + "(id INTEGER not NULL, "
                    + " name VARCHAR(255), "
                    + " age INTEGER, "
                    + " PRIMARY KEY ( id ))";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created successfully...");

            // Insert data into table
            String insertSQL = "INSERT INTO Employees (id, name, age) VALUES (1, 'John Doe', 30)";
            stmt.executeUpdate(insertSQL);
            insertSQL = "INSERT INTO Employees (id, name, age) VALUES (2, 'Jane Smith', 25)";
            stmt.executeUpdate(insertSQL);
            System.out.println("Records inserted successfully...");

            // Select and display data from the table
            String selectSQL = "SELECT id, name, age FROM Employees";
            ResultSet rs = stmt.executeQuery(selectSQL);

            System.out.println("Data from Employees table:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                // Display the retrieved data
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Update data in the table
            String updateSQL = "UPDATE Employees SET age = 35 WHERE id = 1";
            stmt.executeUpdate(updateSQL);
            System.out.println("Record updated successfully...");

            // Delete data from the table
            String deleteSQL = "DELETE FROM Employees WHERE id = 2";
            stmt.executeUpdate(deleteSQL);
            System.out.println("Record deleted successfully...");

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
