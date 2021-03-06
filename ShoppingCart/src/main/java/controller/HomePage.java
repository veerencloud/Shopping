package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Products;
import model.ProductsImpl_DAO;
import model.UserLoginImpl_DAO;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductsImpl_DAO pd = new ProductsImpl_DAO();
		UserLoginImpl_DAO ud = new UserLoginImpl_DAO();
		try {

			List<Products> list = new ArrayList<Products>();
			ud.connection_db();
			list = pd.allProducts();
			resp.sendRedirect("cart.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("prod", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
