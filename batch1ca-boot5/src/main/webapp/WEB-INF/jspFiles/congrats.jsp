<!DOCTYPE html>
<html lang="en">
<head>
<title>login Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>



	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Emailid</th>
					<th>Password</th>
					<th>Salary</th>
				</tr>

			</thead>
			<tbody>

				<tr>
					<td>${employeeDTO.employeeId}</td>
					<td>${employeeDTO.employeeName}</td>
					<td>${employeeDTO.emailId}</td>
					<td>${employeeDTO.password}</td>
					<td>${employeeDTO.salary}</td>
				</tr>

			</tbody>
		</table>
		<a href="showAllEmployee">
			<button type="button" class="btn btn-primary">show all
				records</button>
		</a>

	</div>

</body>
</html>
