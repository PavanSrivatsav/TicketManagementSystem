<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../style.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Find Employee Tickets</title>
</head>
<body>
	<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
		<form>
			<button class="btn btn-primary" style="float: right" type="submit"
				formaction="../userModule/logout">Logout</button>
		</form>
	</div>
	<div class="container">
		<h3 style="text-align: center">Employee name Ticket Details</h3>
		<br>
		<%-- 	To Test Values : ${User_Details} --%>
		<table border="1" class="table table-hover">
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
						<td><a href="../employeeModule?TicketId=${c.id}">Reassign
								Ticket</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<div class="col-lg-6 col-md-6 col-sm-6">
			<h3>Employee Reply Ticket</h3>

			<div id="employeeUpdate">
				<!--  style="display: none" -->
				<form action="../employeeModule/replyticket" method=get>
					Id <br> <input type="number" name="id"
						value=<%=request.getParameter("id")%> class="input__text" required
						autofocus /><br> Solution<br> <input type="text"
						name="solution" class="input__text" required autofocus /><br>
					<br>
					<button type="submit" class="btn btn-primary"
						style="margin-left: 110px;">Submit</button>
				</form>
				${EMP_REPLY_TICKET}
			</div>
		</div>
		<div class="col-lg-6 col-sm-6 col-md-6">
			<h3>Employee Reassign Ticket</h3>

			<div id="employeeReassign">
				<!--  style="display: none" -->
				<form action="../employeeModule/reassignticket" method=get>
					Ticket Number <br> <input type="number" name="TicketId"
						value=<%=request.getParameter("TicketId")%> class="input__text"
						required autofocus /><br> Employee ID<br> <input
						type="text" name="empId" class="input__text" required /><br>
					<br>
					<button type="submit" class="btn btn-primary"
						style="margin-left: 110px;">Submit</button>
				</form>
				${EMP_RE_ASSIGN_TICKET}
			</div>
		</div>
	</div>
</body>
</html>