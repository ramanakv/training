<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">


</head>
<body>
	<div class='container col-4 my-5'>
	<h3 class='text-center'>Employee Application</h3>
		<form action='employees/save' method='get'>

			<table class='table table-striped'>
				<tr>
					<td>Emp Id:</td>
					<td><input type='text' name='empid'></td>
				</tr>

				<tr>
					<td>Name:</td>
					<td><input type='text' name='name'></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><input type='text' name='salary'></td>
				</tr>
				<tr>
					<td>D O B:</td>
					<td><input type='date' name='dob'></td>
				</tr>
				<tr>
					<td colspan='2'>
					<input type='submit' class='btn btn-success' value='Save'> 
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>