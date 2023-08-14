<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body center>
	<h1 align="center">Login Page</h1>
	<form action="<%=request.getContextPath()%>/loginServlet" method="post">
		<div class="container col-md-3 m-5 card p-5">
			<div class="mb-3">
				<label class="form-label">Email address</label> <input type="email"
					class="form-control">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label class="form-label">Password</label> <input type="password"
					class="form-control">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input"> <label
					class="form-check-label">Check me out</label>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
			<a href="Register.jsp">if are you not a register user ! register
				here...</a>
			<div>
				<a href="ForgetPassword.jsp">Forget Password</a>
			</div>
		</div>
	</form>
</body>
</html>