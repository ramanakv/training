<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

</head>
<body>

	<h3>Employee List</h3>
	<table>
		<tr>
			<th>EmpId</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
		<c:forEach var="e" items="${emps}">
			<tr>
				<td>${e.empId}</td>
				<td>${e.name}</td>
				<td>${e.salary}</td>
			</tr>
		</c:forEach>
	</table>
	<h2>${message}</h2>

</body>
</html>