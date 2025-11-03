package com.login;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Employee Records</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background-color: #f3f6fa; padding: 30px; }");
        out.println("table { border-collapse: collapse; width: 80%; background: #fff; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
        out.println("th, td { padding: 10px; text-align: center; border: 1px solid #ddd; }");
        out.println("th { background-color: #0078D7; color: white; }");
        out.println("a { text-decoration: none; color: #0078D7; }");
        out.println("</style></head><body>");

        out.println("<h2>Employee Records</h2>");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "navsi2520@");

            // Execute query
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee");

            out.println("<table>");
            out.println("<tr><th>Emp ID</th><th>Name</th><th>Salary</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("EmpID") + "</td>");
                out.println("<td>" + rs.getString("Name") + "</td>");
                out.println("<td>" + rs.getDouble("Salary") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            // Link to Attendance Page
            out.println("<br><br>");
            out.println("<a href='attendance.jsp'><b>Go to Attendance Portal</b></a>");

        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (stmt != null) stmt.close(); } catch (Exception ignored) {}
            try { if (con != null) con.close(); } catch (Exception ignored) {}
        }

        out.println("</body></html>");
        out.close();
    }
}
