package demo_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String token = UUID.randomUUID().toString();

		// You can do something with the generated token, like storing it in a session
		// or sending it as a response
		// For demonstration purposes, we'll just send it as a response
		response.setContentType("text/plain");
		response.getWriter().write("Generated Token: " + token);
		PrintWriter pw = response.getWriter();
		pw.println("<p>token</p>");

		// You should perform proper validation on the input data

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pooja", "root", "pooja1234");

			String query = "SELECT * FROM users WHERE email = ? AND password = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setString(3, token);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// Successful login
				response.getWriter().write("Login successful!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/UserWelcome.jsp");
				dispatcher.forward(request, response);
			} else {
				// Invalid credentials
				response.getWriter().write("Invalid credentials. Please try again.");
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("An error occurred. Please try again later.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/UserWelcome.jsp");
		dispatcher.forward(request, response);
	}
}