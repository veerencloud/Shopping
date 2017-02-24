<%@page import="model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add prod</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>

</head>
<%
	HttpSession session0 = request.getSession(false);
	List<Products> addedlist = (ArrayList<Products>) session0.getAttribute("addedlist");
%>
<body>
	<center>
		<table>
			<tr>
				<th>product ID</th>
				<th>product name</th>
				<th>product price</th>
				<th>qty</th>
			</tr>

			<%
				for (int i = 0; i < addedlist.size(); i++) {
			%>
			<tr>


				<td>
					<%
						out.println(addedlist.get(i).getProduct_ID());
					%>
				</td>
				<td>
					<%
						out.println(addedlist.get(i).getProduct_name());
					%>
				</td>
				<td>
					<%
						out.println(addedlist.get(i).getProduct_price());
					%>
				</td>
				<td>
					<%
						out.println(addedlist.get(i).getProduct_qty());
					%>
				</td>

			</tr>
			<%
				}
			%>
		</table>
		<a href="logout.jsp">log out</a>
	</center>
	<!-- <a href="AdminHome.jsp">back</a> -->
</body>
</html>