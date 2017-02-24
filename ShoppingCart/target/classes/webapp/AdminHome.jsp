<%@page import="model.Products"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="model.UserLogin_DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
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
	background-color: #ff8000;
	color: white;
}
</style>

</head>
<body>
	<%@page import="java.util.*"%>
	<center>
		<h1>Admin Home page</h1>
	</center>
	<%
		HttpSession session0 = request.getSession(false);
		List<Products> product = (ArrayList<Products>) session0.getAttribute("prod");
		/* session3.getAttribute("prod"); */
		//out.println(product.get(0).getProduct_name());
		/* List<String>quantity = new ArrayList<>(); */
	%>
	<center>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>User Name</th>
				<th>Password</th>
			</tr>
			<%
				UserLogin_DAO ud = new UserLogin_DAO();
				PreparedStatement pst = null;
				Connection con = ud.connection_db();
				pst = con.prepareStatement("select * from users");
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
			</tr>
			<%
				}
			%>

		</table>
		<!--  for products table -->
		<br> <br>
		<table>
			<TR>
				<th>product ID</th>
				<th>product name</th>
				<th>product price</th>
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
				<%-- <% product.add(product.get(i).getProduct_qty()) %> --%>

			</tr>
			<%
				}
			%>
		</table>
		<form method="post" style="text-align: center;">
			<br>
			<p>Use the below form to update using the product ID</p>
			product_ID:<input type="text" name="product_ID" value="0"><br>
			product_name:<input type="text" name="product_name" value=" "><br>
			product_price:<input type="text" name="product_price" value="0"><br>
			product_qty:<input type="text" name="product_qty" value="0"><br>
			<br>

			<button type="submit" name="AdminUpdate" formaction="AdminUpdate">Update</button>
			<button type="submit" name="AdminAdd" formaction="AdminAdd">Add</button>
			<button type="submit" name="AdminDelete" formaction="AdminDelete">Delete</button>
		</form>


	</center>
	<!-- <a href="login.jsp">back</a> -->
</body>
</html>