<%-- 
    Document   : index
    Created on : 1 Mar 2025, 12:05:46 am
    Author     : acj32
--%>
<%@page import="controllers.TestConnection"%>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            table {
                width: 50%;
                border-collapse: collapse;
                margin: 20px 0;
            }
            th, td {
                border: 1px solid black;
                padding: 10px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            form {
                display: inline;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>

        <h2>User List</h2>
        <table>
            <tr>
                <th>Username</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            <%
                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                try {
                    conn = TestConnection.connect();
                    stmt = conn.prepareStatement("SELECT user_name, user_role FROM account ORDER BY user_role DESC, user_name ASC");
                    rs = stmt.executeQuery();

                    while (rs.next()) {
                        String uName = rs.getString("user_name");
                        String role = rs.getString("user_role");

                        out.println("<tr>");
                        out.println("<td>" + uName + "</td>");
                        out.println("<td>" + role + "</td>");
                        out.println("<td>"
                                + "<form action='delete.jsp' method='post' onsubmit='return confirm(\"Are you sure you want to delete " + uName + "?\")'>"
                                + "<input type='hidden' name='deleteUser' value='" + uName + "'>"
                                + "<button type='submit'>Delete</button></form> "
                                + "<form action='update.jsp' method='post'>"
                                + "<input type='hidden' name='updateUser' value='" + uName + "'>"
                                + "<button type='submit'>Update</button></form></td>");
                        out.println("</tr>");
                    }
                } catch (SQLException e) {
                    out.println("<p>Error fetching users: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                } finally {
                    if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
                    if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
                    if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
                }
            %>
        </table>
    </body>
</html>
