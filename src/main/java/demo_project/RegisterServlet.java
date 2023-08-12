package demo_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	Connection con;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pooja", "root", "pooja1234");
		} catch (Exception e) {
			e.getSuppressed();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		String email = request.getParameter("email");
		String number = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("congirm_password");

		try {
			String q = "INSERT INTO user(email, number, address, password, confirm_password) VALUES(?,?,?,?,?)";

			PreparedStatement p = con.prepareStatement(q);

			p.setString(1, email);
			p.setString(2, number);
			p.setString(3, address);
			p.setString(4, password);
			p.setString(5, confirm_password);

			int rowsInserted = p.executeUpdate();
		
			if (rowsInserted > 0) {
				String successMessage = "Registration successful!";
				response.getWriter().write(successMessage);
				
			} else {
				String errorMessage = "Registration failed. Please try again.";
				response.getWriter().write(errorMessage);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "An error occurred. Please try again later.";
			response.getWriter().write(errorMessage);
		}

//		System.out.println(gmail + number + address + password + confirm_password);
//		System.out.println(con);
	}

}
