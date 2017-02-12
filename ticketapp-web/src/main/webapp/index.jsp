
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<body>
	<h2>Welcome to ticket Management System</h2>
	<!-- <form action="department" method=get>
		<button type="submit">Department</button>
	</form>
 -->
	<br>
	<h4>User Login</h4>

	<form method=get>
		<label for="userEmailId"> Email Id:</label><br> <input
			type="text" name="userEmail" id="userEmailId" /><br> <br>
		<label for="password"> Password:</label> <br> <input
			type="password" name="userPassword" id="userPassword" /><br> <br>

		<button class="btn btn-primary" type="submit"
			formaction="/userLogin">Login</button>
		<button class="btn btn-primary" type="submit"
			formaction="../userRegistration">Register</button>
		${USER_LOGIN}
	</form>
	<h4>Employee Login</h4>
	<form action="../employeeLogin" method=get>
		<label for="empEmailId"> Email Id:</label> <br> <input
			type="text" name="empEmail" id="empEmailId" required /><br> <br>
		<label for="empPassword"> Password: </label> <br> <input
			type="password" name="empPassword" id="empPassword" required /><br>
		<br>
		<button class="btn btn-primary" type="submit">Login</button>
		${EMPLOYEE_LOGIN}
	</form>

</body>
</html>


