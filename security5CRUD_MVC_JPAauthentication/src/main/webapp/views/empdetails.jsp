<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



</head>
<body>
	<div>
		<h3>Emp Details</h3>
		<div>
			<table>
				<tr>
					<td>Employee Id</td>
					<td>${emp.empId}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${emp.name}</td>
				</tr>

				<tr>
					<td>Salary</td>
					<td>${emp.salary}</td>
				</tr>
			</table>
		</div>
		
	</div>
</body>
</html>