
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../style.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<body>
	<h2 style="text-align: center">Welcome to ticket Management System</h2>

	<br>
	<div class="container">
		<br>
		<div class="col-lg-6 col-md-6 col-sm-6">
			<h4 style="margin-left: 90px">User Login</h4>
			<form method=get>
				<label for="userEmailId"> Email Id:</label><br> <input
					type="text" name="userEmail" id="userEmailId" class="input__text" /><br>
				<br> <label for="password"> Password:</label> <br> <input
					type="password" name="userPassword" id="userPassword"
					class="input__text" /><br> <br>

				<button class="btn btn-primary" type="submit"
					formaction="/userLogin" style="margin-left: 50px;">Login</button>
				<button class="btn btn-primary" type="submit"
					formaction="../userRegistration">Register</button>
				${USER_LOGIN}
			</form>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6">
			<h4 style="margin-left: 90px">Employee Login</h4>
			<form action="../employeeLogin" method=get>
				<label for="empEmailId"> Email Id:</label> <br> <input
					type="text" name="empEmail" id="empEmailId" class="input__text"
					required /><br> <br> <label for="empPassword">
					Password: </label> <br> <input type="password" name="empPassword"
					id="empPassword" class="input__text" required /><br> <br>
				<button class="btn btn-primary" type="submit"
					style="margin-left: 100px;">Login</button>
				${EMPLOYEE_LOGIN}
			</form>
		</div>
	</div>

</body>
</html>


