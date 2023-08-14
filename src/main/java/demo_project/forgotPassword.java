package demo_project;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class forgotPassword
 */
@WebServlet("/ForgotPasswordServlet")
public class forgotPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        // Generate a unique token for password reset (e.g., using UUID)
        String token = request.getParameter("token");

        // Store the token and email in the database for verification later
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pooja", "root", "pooja1234");

            String query = "INSERT INTO password_reset_tokens (email, token) VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, token);
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("An error occurred. Please try again later.");
            return;
        }

        // Send an email with the reset link containing the token
        String resetLink = "http://yourapp.com/reset-password?token=" + token;

        // Code to send the email

        response.getWriter().write("Password reset link sent to your email.");
    }
}
