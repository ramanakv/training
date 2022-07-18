<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class='container col-4 p-5 my-5 bg-primary text-white'>
	<h3>Employee Data</h3>
	<table class='table table-danger'>
		<tr>
			<td>Emp Id:</td>
			<td>${emp.empId}</td>
		</tr>
	
		<tr>
			<td>Name:</td>
			<td>${emp.name}</td>
		</tr>
		
		<tr>
			<td>Salary:</td>
			<td>${emp.salary}</td>
		</tr>
	
		<tr>
			<td>D O B:</td>
			<td>${emp.dob}</td>
		</tr>
	
	</table>
	
	<a  class='text-danger'href='index.html'>Back</a>
	</div>
</body>
</html>