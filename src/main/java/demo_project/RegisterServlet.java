package demo_project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirmPassword");

		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish a connection to the database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pooja", "root",
					"pooja1234");

			// Prepare the SQL INSERT query
			String insertQuery = "INSERT INTO user (email, phoneNumber, address, password, confirm_password) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, phoneNumber);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, confirm_password);

			// Execute the query
			preparedStatement.executeUpdate();

			// Close resources
			preparedStatement.close();
			connection.close();

			// Redirect to a success page
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
//            response.sendRedirect("WEB-INF/views/UserWelcome.jsp");
//            System.out.println(email + phoneNumber + address + password + confirm_password);
//    		System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();

			// Redirect to an error page
			response.sendRedirect("");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
