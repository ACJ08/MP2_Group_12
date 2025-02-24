/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author acj32
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TestConnection {
    public static void main(String[] args) {
         String url = "jdbc:mysql://localhost:3306/WebApplicationDB"; // Ensure the database name is correct
        String user = "root"; // Your MySQL username
        String password = "1234"; // Your MySQL password

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection successful!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found! " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection failed! " + e.getMessage());
        }
    
    }
            
}
