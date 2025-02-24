
package controllers;


import java.sql.*;
/**
 *
 * @author acj32
 */
public class ConnectDatabase {
    
 private static final String jdbcUrl = "jdbc:mysql://localhost:3306/WebApplicationDB";
    private static final String user = "root"; // Change if needed
    private static final String password = "1234"; // Change to your MySQL password

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Database connection successful!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = connect();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}