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
<title>Department Page</title>
</head>
<body>

	<h3>Department List</h3>
	<%-- 	To Test Values : ${DEPARTMENT_LIST} --%>
	<table border="1">
		<thead>
			<tr>
				<th>Sno</th>
				<th>Name</th>
				<th>Active</th>
				<th>Remove</th>
				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${DEPARTMENT_LIST}" varStatus="i">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.status}</td>
					<td><a href="../department/delete?id=${c.id}">Delete</a></td>
					<td onclick="display()"><a href="../department?id=${c.id}">Edit</a></td>
					<%-- <a href="department?id=${c.id}"></a> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<br>
	<h4>Add department</h4>
	<form action="../department/save" method=get>
		Name<br> <input type="text" name="deptname" required autofocus />
		<button type="submit">Submit</button>
	</form>
	${INSERT_ERROR} ${DELETE_ERROR}
	<h4>Update Department</h4>
	<div id="update" >  <!--  style="display: none" -->
		<form action="../department/update" method=get>
			Id <br> <input type="number" name="id" value=<%=request.getParameter("id")%> required autofocus /><br>
			Name<br> <input type="text" name="upDeptname" required autofocus /><br>
			Status<br> <input type="text" name="status" required autofocus /><br>
			<br>
			<button type="submit">Submit</button>
		</form>
	</div>

<!-- 	<script type="text/javascript">
		function display() {

			var toogle = document.getElementById("update");
			if (toogle.style.display != 'none') {
				console.log("display off");
				toogle.style.display = 'none';

			}
	
			else {
				console.log("display on");
				toogle.style.display = '';

			}
		}
	</script> -->
</body>
</html>