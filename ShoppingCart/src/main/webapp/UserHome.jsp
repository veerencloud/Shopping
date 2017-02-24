<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Products"%>
<%@ page import="model.Products_DAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Page</title>
<style>
.button {
	padding: 15px 25px;
	font-size: 24px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: #fff;
	background-color: #4CAF50;
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #999;
}

.button:hover {
	background-color: #3e8e41
}

.button:active {
	background-color: #3e8e41;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}
</style>
</head>
<body>
	<%
		Products_DAO p = new Products_DAO();
	%>
	<form action="HomePage" method="post">
		<center>
			<h1>Welcome to ceasers</h1>
			<h2>Choose from our varied collection of items</h2>
			<h3>To see the available products please click below</h3>
			<button class="button">list of products</button>
		</center>
	</form>
	<!-- <a href="login.jsp">back</a> -->
</body>
</html>