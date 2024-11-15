/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sherrylochieng
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/registration_db";
    private static final String USER = "root"; // Default MySQL username in XAMPP
    private static final String PASSWORD = ""; // Default MySQL password in XAMPP (leave blank if not set)

    private Connection connection;

    public DatabaseManager() {
        try {
            // Establishing connection with the MySQL database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }

    // Method to insert user data into the database
    public boolean insertUser(String id, String name, String gender, String address, String contact) {
        String query = "INSERT INTO users (id, name, gender, address, contact) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Integer.parseInt(id));
            statement.setString(2, name);
            statement.setString(3, gender);
            statement.setString(4, address);
            statement.setString(5, contact);
            
            statement.executeUpdate();
            System.out.println("Data inserted successfully!");
            return true;
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
            return false;
        }
    }

    // Closing the database connection when done
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close the database connection: " + e.getMessage());
        }
    }
}

