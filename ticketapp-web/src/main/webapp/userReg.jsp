<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<form action="../userRegistration/register" method=get>
		<br> Name : &nbsp;&nbsp;<input type="text" name="username"
			required /><br> <br> <br> Email Id : &nbsp;&nbsp;<input
			type="text" name="userEmail" required /><br> <br> Password
		: <input type="password" name="userPassword" required /><br> <br>
		<button type="submit" class="btn btn-primary">Register</button>
	</form>
	${USER_REGISTRATION}
</body>
</html>