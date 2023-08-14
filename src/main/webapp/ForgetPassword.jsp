<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Forgot Password</h1>
		<form action="<%=request.getContextPath()%>/ForgotPasswordServlet"
			method="post">
			Email: <input type="email" name="email" required><br><br><br> <input
				type="submit" value="Submit">
		</form>
	</div>
</body>
</html>