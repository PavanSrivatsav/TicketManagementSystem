<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<h2>Ticket List</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Ticket Id</th>
				<th>Subject</th>
				<th>Description</th>
				<th>Status</th>
				<th>Delete</th>
				<th>Assign Ticket</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${ADMIN_TICKET_LIST}" varStatus="i">
				<tr>
					<td>${c.id}</td>
					<td>${c.subject}</td>
					<td>${c.description}</td>
					<td>${c.status}</td>
					<td><a href="../adminModule/delete?id=${c.id}">Delete</a></td>
					<td><a href="../adminModule?ticketId=${c.id}">Assign</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${DELETE_ERROR}

	<form action="../adminModule/assignTicket" method=get>
		TicketId <br> <input type="number" name="ticketId"
			value=<%=request.getParameter("ticketId")%> required autofocus /><br>
		Employee Id <br> <input type="number" name="employeeId" required
			autofocus /><br> <br>
		<button class="btn btn-primary" type="submit">Assign Ticket</button>
	</form>
	${ASSIGN_ERROR}
	<br>
	<br>
	<form method=get>
		<button class="btn btn-primary" type="submit" formaction="/department">Department</button>
	</form>
</body>
</html>