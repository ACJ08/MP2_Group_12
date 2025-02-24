package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author acj32
 */
public class InsertDataServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertDataServ</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertDataServ at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        Connection conn=null;
        
//        Statement stmt=null;
//        String n="", p="";
//        n =request.getParameter("txtuname");
//        p = request.getParameter("txtupass");
//        
//        try{
//            //initialize JDBC Driver
//            Class.forName("com.mysql.jdbc.Driver");
//            //Establish the connection with mysql database
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/WebApplicationDB", "root", "1234");
//            //create an object of statement class which is responsible for executing queries
//            stmt=conn.createStatement();
//            //use executeUpdate() to execute the insert query
////            stmt.executeUpdate("insert into usertab values ('" +n+" ','' " + p + "')");
//            out.print("<h1>Your account is created successfully!!");
//            
//        }catch (Exception e) {
//            out.println("Sorry!!! Try again later.");
//        }

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebApplicationDB", "root", "1234");
        
        if (conn != null) {
            out.println("<h1>Database connection successful!</h1>");
        } else {
            out.println("<h1>Failed to connect to the database.</h1>");
        }
    } catch (ClassNotFoundException e) {
        out.println("<h1>JDBC Driver not found: " + e.getMessage() + "</h1>");
    } catch (SQLException e) {
        out.println("<h1>Database connection failed: " + e.getMessage() + "</h1>");
    } finally {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            out.println("<h1>Error closing connection: " + e.getMessage() + "</h1>");
        }
    }
        
    }//doGet

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
