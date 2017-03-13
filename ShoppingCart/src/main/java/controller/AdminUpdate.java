package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminImpl_DAO;
import model.Products;
import model.ProductsImpl_DAO;

@WebServlet("/AdminUpdate")
public class AdminUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AdminImpl_DAO ad = new AdminImpl_DAO();
	ProductsImpl_DAO pd = new ProductsImpl_DAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int product_ID = Integer.parseInt(req.getParameter("product_ID"));
		String product_name = req.getParameter("product_name");
		float product_price = Float.parseFloat(req.getParameter("product_price"));
		int product_qty = Integer.parseInt(req.getParameter("product_qty"));
		if (product_ID != 0) {
			ad.adminedit(product_ID, product_name, product_price, product_qty);
			List<Products> updatelist = pd.allProducts();
			HttpSession session0 = req.getSession();
			session0.setAttribute("updatelist", updatelist);

			resp.sendRedirect("updateprod.jsp");

		} else
			resp.sendRedirect("AdminHome.jsp");

	}

}
