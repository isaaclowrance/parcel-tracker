package parcel.tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/parceltracker"; // replace with your DB URL
    private static final String USER = "root";  // replace with your DB username
    private static final String PASSWORD = "root";  // replace with your DB password

    // The connection object
    private static Connection connection = null;

    // Method to establish the database connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the MySQL JDBC driver (optional in modern JDBC versions)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish the connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Failed to connect to the database.");
            }
        }
        return connection;
    }

}
