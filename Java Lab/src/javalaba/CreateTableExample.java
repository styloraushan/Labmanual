package javalaba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableExample {

    // MySQL database credentials
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/userdb"; // Replace with your database name
    static final String USER = "root"; // Replace with your MySQL username
    static final String PASS = "raushanR@123"; // Replace with your MySQL password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Step 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query to create the table
            System.out.println("Creating table in the database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE student " +
                    "(id INT NOT NULL, " +
                    " name VARCHAR(255), " +
                    " age INT, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Table 'Employees' created successfully...");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Step 4: Clean-up environment
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
