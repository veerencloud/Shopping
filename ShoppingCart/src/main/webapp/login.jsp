<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style>
.button {
	position: relative;
	background-color: #4CAF50;
	border: none;
	font-size: 18px;
	color: #FFFFFF;
	padding: 20px;
	width: 100px;
	text-align: center;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	text-decoration: none;
	overflow: hidden;
	cursor: pointer;
}

.button:after {
	content: "";
	background: #90EE90;
	display: block;
	position: absolute;
	padding-top: 100%;
	padding-left: 150%;
	margin-left: -20px !important;
	margin-top: -120%;
	opacity: 0;
	transition: all 0.8s
}

.button:active:after {
	padding: 0;
	margin: 0;
	opacity: 1;
	transition: 0s
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="UserLogin" method="post">
		<center>
			<h1>
				<font color="teal">Welcome to Cesears world of shopping</font>
			</h1>
			<table border="1" cellpadding="5" cellspacing="2">
				<thead>
					<tr>
						<th colspan="2"><center>Login</center></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Username</td>
						<td><input type="text" name="UserName" required /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="Password" required /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><button class="button">Log
								in</button> &nbsp;&nbsp; <br> <a href="register.jsp">New User?
								please register</a></td>
					</tr>
				</tbody>
			</table>
	</form>
	</center>
</body>
</html>