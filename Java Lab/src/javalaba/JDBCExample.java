package javalaba;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCExample {

    public static void main(String[] args) {
        // Scanner for reading user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for username and password
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Database credentials
        String dbUrl = "jdbc:mysql://localhost:3306/userdb";
        String dbUser = "root";  // Replace with your MySQL username
        String dbPassword = "raushanR@123";  // Replace with your MySQL password

        // JDBC variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Load the MySQL JDBC driver (if required for your setup)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Create SQL query to check if the user exists in the database
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Execute the query
            rs = stmt.executeQuery();

            // Check if credentials are valid
            if (rs.next()) {
                System.out.println("Login Successful! Welcome, " + username);
            } else {
                System.out.println("Invalid Username or Password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close all connections
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
