
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Employee Registration</title>
</head>
<body>
	<h2>Employee Registration</h2>
	<br>
	<br>
	<br>
	<form action="" method="get">
		<br> EmailId : <input type="text" name="emailId" required /><br>
		<br> Password : <input type="password" name="pwd" required /><br>
		<br> Department : <select name="dept">
			<option value="HR">HR</option>
			<option value="finance">Finance</option>
		</select><br> <br> Role : <select name="dept">
			<option value="Admin">Admin</option>
			<option value="Employee">Developer</option>
		</select><br> <br>
		<button type="submit">Register</button>

	</form>
</body>
</html>