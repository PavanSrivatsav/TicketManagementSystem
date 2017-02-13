<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../style.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<div class="container" style="text-align: center;">
		<h2>User Registration</h2>
		<br>
		<form action="../userRegistration/register" method=get
			style="margin-top: 10%">
			<br> Name : <br>&nbsp;&nbsp;<input type="text"
				name="username" class="input__text" required /><br> <br>
			<br> Email Id : <br>&nbsp;&nbsp;<input type="text"
				name="userEmail" class="input__text" required /><br> <br>
			Password : <br> <input type="password" name="userPassword"
				class="input__text" required /><br> <br>
			<button type="submit" class="btn btn-primary">Register</button>
		</form>
		${USER_REGISTRATION}
	</div>
</body>
</html>