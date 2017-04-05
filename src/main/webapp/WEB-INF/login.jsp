<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
	<div class="container-fluid">
		<h1 class="text-center">Login | Page</h1><hr>
	</div>
	<div class="container">
		<div class="col-md-12">
			<form action="login" method="POST">
				<div class="form-group">
					<label>Username</label>
					<input type="text" placeholder="Username" class="form-control">
				</div>
				<div class="form-group">
					<label>Password</label>
					<input type="password" placeholder="Password" class="form-control">
				</div>
				<div class="form-group">
					<input type="submit" value="Login" class="btn btn-primary">
				</div>
			</form>
		</div>
		
	</div>
</body>
</html>