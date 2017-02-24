<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
<style>
div {
	background-color: #e6ffff;
	width: 300px;
	border: 10px solid #0000cc;
	padding: 25px;
	margin: 25px;
}
</style>
</head>
<body>
	<center>
		<div>
			<h1>
				<font color="teal">Please register to enter the world of
					options</font>
			</h1>
			<form action="UserRegister" method="post">
				Firstname: <input type="text" name="Firstname" required><br>
				Lastname: <input type="text" name="Lastname" required><br>
				Username: <input type="text" name="UserName" required><br>
				Password: <input type="password" name="Password" required><br>
				Confirm : <input type="password" name="ConfirmPassword" required><br>
				<input type="submit" value="Register"></input>
		</div>


		</form>
	</center>
</body>
</html>