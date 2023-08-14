<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<form action="<%=request.getContextPath()%>/RegisterServlet"
		method="post">
		<h1 align="center">Registration Form</h1>
		<div class="container col-md-3 m-5 card p-5">
			<div class="mb-3">
				<label class="form-label">Enter your email</label> <input
					type="email" name="email" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Phone number</label> <input type="phone"
					name="phoneNumber" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Address</label> <input type="text"
					name="address" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Password</label> <input type="password"
					name="password" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Confirm Password</label> <input
					type="password" name="confirmPassword" class="form-control">
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
			<a href="index.jsp">if are you register user ! login here...</a>
		</div>
	</form>
</body>
</body>
</html>