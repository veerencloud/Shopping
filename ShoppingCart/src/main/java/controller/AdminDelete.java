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

@WebServlet("/AdminDelete")
public class AdminDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ProductsImpl_DAO pd = new ProductsImpl_DAO();
	AdminImpl_DAO ad = new AdminImpl_DAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in delete");
		int product_ID = Integer.parseInt(req.getParameter("product_ID"));

		if (product_ID != 0) {
			System.out.println(product_ID);
			ad.deleteprod(product_ID);
			List<Products> deletelist = pd.allProducts();
			HttpSession session0 = req.getSession();
			session0.setAttribute("deletelist", deletelist);
			resp.sendRedirect("deleteprod.jsp");

		}

		else {
			resp.sendRedirect("AdminHome.jsp");
		}

	}
}
