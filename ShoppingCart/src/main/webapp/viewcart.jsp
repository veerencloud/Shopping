<%@page import="model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view cart</title>
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
	background-color: #0052cc;
	color: white;
}
</style>
</head>
<body>
	<%@page import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
		HttpSession session3 = request.getSession(false);
		List<Products> itemslist = (List<Products>) session3.getAttribute("itemslist");
		List<Double> total = (List<Double>) session3.getAttribute("total");
		List<Integer> qtyall = (List<Integer>) session3.getAttribute("qtyall");
		//int qty=(int)session3.getAttribute("qty");
		/* out.println(product.get(0).getProduct_name()); */
	%>
	<center>
		<table>
			<tr>
				<th>product ID</th>
				<th>product name</th>
				<th>product price</th>
				<th>qty</th>
				<th>total
				<th>
			</tr>

			<%
				for (int i = 0; i < itemslist.size(); i++) {
			%>
			<tr>

				<td>
					<%
						out.println(itemslist.get(i).getProduct_ID());
					%>
				</td>
				<td>
					<%
						out.println(itemslist.get(i).getProduct_name());
					%>
				</td>
				<td>
					<%
						out.println(itemslist.get(i).getProduct_price());
					%>
				
				<td>
					<%
						out.println(qtyall.get(i));
					%>
				</td>
				<td>
					<%
						out.println(total.get(i));
					%>
				</td>
			</tr>


			<%
				}
			%>


		</table>

		<h3>please pay while you log out</h3>
		<h3>
			<a href="logout.jsp">log out</a>
		</h3>
	</center>
	<!-- <a href="cart.jsp">back</a> -->
</body>
</html>