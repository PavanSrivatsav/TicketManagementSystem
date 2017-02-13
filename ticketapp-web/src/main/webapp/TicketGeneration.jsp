<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../style.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket</title>
</head>
<body>
	<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
		<form>
			<button class="btn btn-primary" style="float: right" type="submit"
				formaction="../userModule/logout">Logout</button>
		</form>
	</div>
	<div class="container">
		<h2 style="text-align: center">Ticket Display</h2>
		<br>
		<table border="1" class="table table-hover">
			<thead>
				<tr>
					<th>Ticket Id</th>
					<th>Subject</th>
					<th>Description</th>
					<th>Status</th>
					<th>Update</th>
					<th>Close Ticket</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${USER_TICKET_LIST}" varStatus="i">
					<tr>
						<td>${c.id}</td>
						<td>${c.subject}</td>
						<td>${c.description}</td>
						<td>${c.status}</td>
						<td><a href="../userModule?id=${c.id}">Edit</a></td>
						<td><a href="../userModule/ticketClose?id=${c.id}">Close</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		${TICKET_UPDATE_ERROR}
		<div class="col-lg-6 col-sm-6 col-md-6 col-xs-6">
			<h2>Ticket Generation</h2>
			<br>
			<form action="../userModule/ticketInsert" method="get">
				Subject : <br> <input type="text" name="subject" required
					autofocus /> <br> <br> Description : <br> <input
					type="text" name="description" required /><br> <br>
				Department : <select name="dept">
					<option value="1">HR</option>
					<option value="2">Finance</option>
				</select><br> <br> Priority :<select name="priority">
					<option value="High">High</option>
					<option value="Medium">Medium</option>
					<option value="Low">Low</option>
				</select><br> <br>
				<button type="submit" class="btn btn-primary">Submit</button>

				${TICKET_ERROR} ${TICKET_CLOSE_ERROR}
			</form>
		</div>
		<div class="col-lg-6 col-sm-6 col-md-6 col-xs-6">
			<h2>Ticket Edit</h2>
			<form action="../userModule/ticketEdit" method="get">
				<br>Ticket ID :<br> <input type="number"
					value=<%=request.getParameter("id")%> name="id" class="input__text"
					required autofocus /> <br> <br>Subject :<br> <input
					type="text" name="editsubject" class="input__text" required
					autofocus /> <br> <br> Description :<br> <input
					type="text" name="editdescription" class="input__text" required /><br>
				<br> Status :<select name="editstatus">
					<option value="OPEN">Open</option>
					<option value="CLOSED">Closed</option>
				</select><br> <br>
				<button type="submit" class="btn btn-primary">Submit</button>

				${TICKET_UPDATE_ERROR}
			</form>
		</div>
	</div>
</body>
</html>