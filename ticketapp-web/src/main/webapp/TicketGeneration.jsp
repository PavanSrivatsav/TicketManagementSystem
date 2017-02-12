<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket</title>
</head>
<body>

	<h2>Ticket Display</h2>
	<table border="1">
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
	<h2>Ticket Generation</h2>
	<br>
	<form action="../userModule/ticketInsert" method="get">
		Subject : <input type="text" name="subject" required autofocus /> <br>
		<br> Description : <input type="text" name="description" required /><br>
		<br> Department : <select name="dept">
			<option value="1">HR</option>
			<option value="2">Finance</option>
		</select><br> <br> Priority :<select name="priority">
			<option value="High">High</option>
			<option value="Medium">Medium</option>
			<option value="Low">Low</option>
		</select><br> <br>
		<button type="submit">Submit</button>
		<%-- <c:if test="${TICKET_ERROR !=null}">
			<p onload=fn()>
				Error is:
				<c:out value="${TICKET_ERROR}" />
			<p>
		</c:if> --%>
		${TICKET_ERROR} ${TICKET_CLOSE_ERROR}
	</form>
	<!-- 	<script type="text/javascript">
		var a = '${TICKET_ERROR}';
		function fn() {
			alert(a);
		}
	</script> -->

	<h2>Ticket Edit</h2>
	<form action="../userModule/ticketEdit" method="get">
		<br>Ticket ID : <input type="number"
			value=<%=request.getParameter("id")%> name="id" required autofocus />
		<br> <br>Subject : <input type="text" name="editsubject"
			required autofocus /> <br> <br> Description : <input
			type="text" name="editdescription" required /><br> <br>
		Status :<select name="editstatus">
			<option value="OPEN">Open</option>
			<option value="CLOSED">Closed</option>
		</select><br> <br>
		<button type="submit">Submit</button>

		${TICKET_UPDATE_ERROR}
	</form>
</body>
</html>