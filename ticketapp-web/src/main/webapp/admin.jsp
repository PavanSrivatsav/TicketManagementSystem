<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Admin Login</h4>
	<form action="../adminModule" method=get>
		<label for="adminEmailId"> Email Id:</label> <br> <input
			type="text" name="adminEmail" id="adminEmailId" required /><br>
		<br> <label for="adminPassword"> Password: </label> <br> <input
			type="password" name="adminPassword" id="adminPassword" required /><br>
		<br>
		<button class="btn btn-primary" type="submit">Login</button>
		${ADMIN_LOGIN}
	</form>
</body>
</html>