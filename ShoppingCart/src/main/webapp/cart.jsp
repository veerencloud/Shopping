<%@page import="model.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
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
<style>
.button {
	background-color: #0052cc;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>

</head>
<body>
	<%@page import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
		HttpSession session3 = request.getSession(false);
		List<Products> product = (ArrayList<Products>) session3.getAttribute("prod");
		/* session3.getAttribute("prod"); */
		//out.println(product.get(0).getProduct_name());
		/* List<String>quantity = new ArrayList<>(); */
	%>
	<center>

		<form action="ProductCart" method="post">
			<table>
				<TR>
					<Th>product ID</Th>
					<Th>product name</Th>
					<Th>product price</Th>
					<Th>available qty</Th>
					<th>qty</th>
				</TR>
				<%
					for (int i = 0; i < product.size(); i++) {
				%>
				<tr>


					<td>
						<%
							out.println(product.get(i).getProduct_ID());
						%>
					</td>
					<td>
						<%
							out.println(product.get(i).getProduct_name());
						%>
					</td>
					<td>
						<%
							out.println(product.get(i).getProduct_price());
						%>
					</td>
					<td>
						<%
							out.println(product.get(i).getProduct_qty());
						%>
					</td>
					<td><input type="number" name="product_qty<%=i%>" value="0"
						min="0" max="<%=product.get(i).getProduct_qty()%>"></td>
					<%-- <% product.add(product.get(i).getProduct_qty()) %> --%>
				</tr>
				<%
					}
				%>
				<br>
			</table>
			<!-- <input type="submit" value="cart"><br> -->
			<button class="button">view cart</button>
	</center>
	</form>

	<!-- <a href="UserHome.jsp">back</a> -->
</body>
</html>