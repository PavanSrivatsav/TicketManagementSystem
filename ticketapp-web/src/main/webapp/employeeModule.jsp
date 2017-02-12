<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Find Employee Tickets</title>
</head>
<body>

	<h3>Employee name Ticket Details</h3>
	<%-- 	To Test Values : ${User_Details} --%>
	<table border="1">
		<thead>
			<tr>
				<th>Ticket Id</th>
				<th>subject</th>
				<th>description</th>
				<th>status</th>
				<th>priority</th>
				<th>Update</th>
				<th>Communicate</th>
				<th>Reassign To Another Employee</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${EMP_TICKET_LIST}" varStatus="i">
				<tr>
					<td>${c.id}</td>
					<td>${c.subject}</td>
					<td>${c.description}</td>
					<td>${c.status}</td>
					<td>${c.priority}</td>
					<td><a href="../employeeModule/resolve?id=${c.id}">Resolve</a></td>
					<td><a href="../employeeModule?id=${c.id}">Reply</a></td>
					<td><a href="../employeeModule?TicketId=${c.id}">Reassign Ticket</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />

	<h3>Employee Reply Ticket</h3>

	<div id="employeeUpdate">
		<!--  style="display: none" -->
		<form action="../employeeModule/replyticket" method=get>
			Id <br> <input type="number" name="id"
				value=<%=request.getParameter("id")%> required autofocus /><br>
			Solution<br> <input type="text" name="solution" required
				autofocus /><br> <br>
			<button type="submit">Submit</button>
		</form>
		${EMP_REPLY_TICKET}
	</div>
	<h3>Employee Reassign Ticket</h3>

	<div id="employeeReassign">
		<!--  style="display: none" -->
		<form action="../employeeModule/reassignticket" method=get>
			Ticket Number <br> <input type="number" name="TicketId"
				value=<%=request.getParameter("TicketId")%> required autofocus /><br>
			Employee ID<br> <input type="text" name="empId" required /><br>
			<br>
			<button type="submit">Submit</button>
		</form>
		${EMP_RE_ASSIGN_TICKET}
	</div>
</body>
</html>