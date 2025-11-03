package com.login;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get username and password from HTML form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple hardcoded validation
        if ("admin".equals(username) && "admin123".equals(password)) {
            out.println("<html><body>");
            out.println("<h2>Welcome " + username + "</h2>");
            out.println("<p>Login successful!</p>");
            out.println("<a href='EmployeeServlet'>View Employee Records</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Invalid username or password</h2>");
            out.println("<a href='login.html'>Try again</a>");
            out.println("</body></html>");
        }
    }
}
