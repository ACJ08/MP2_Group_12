package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acj32
 */
public class TestConnection {
    
    private Connection conn;

    // Constructor to initialize the connection
    public TestConnection() {
        this.conn = connect();
        if (this.conn != null) {
            System.out.println("Database Connection Successful");
        } else {
            System.out.println("Database Connection Failed");
        }
    }

    // Static method to establish the connection
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/WebApplicationDB?useSSL=false&allowPublicKeyRetrieval=true"; 
            String user = "root";  // Update with your username
            String password = "1234";  // Update with your password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        }catch (ClassNotFoundException ex) {
           throw new RuntimeException("JDBC Driver Not Found", ex);
        }
        catch (SQLException e) {
            throw new RuntimeException("Database Connection Failed: " + e.getMessage(), e);
        }
    }
    
    public static void main(String[] args) {
        new TestConnection();
    }
}
