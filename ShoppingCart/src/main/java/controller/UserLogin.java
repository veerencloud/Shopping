package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import model.User;
import model.UserLoginImpl_DAO;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	User user = new User();
	UserLoginImpl_DAO ud = new UserLoginImpl_DAO();
	AdminImpl_DAO ad = new AdminImpl_DAO();
	ProductsImpl_DAO pd = new ProductsImpl_DAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		List<Products> list = new ArrayList<Products>();
		String UserName = req.getParameter("UserName");
		String Password = req.getParameter("Password");
		if (UserName.equals("admin")) {
			ad.getuser("admin");
			resp.sendRedirect("AdminHome.jsp");
			list = pd.allProducts();
			HttpSession session0 = req.getSession();
			session0.setAttribute("prod", list);
		}

		else {
			if (Password.equals(ud.getuser(UserName).getPassword())) {
				ud.getuser(UserName);
				resp.sendRedirect("UserHome.jsp");
				pw.println("login Successful");
				HttpSession session1 = req.getSession();
				session1.setAttribute("UserName", UserName);
				HttpSession session2 = req.getSession();
				session2.setAttribute("prod", list);

			} else {
				resp.sendRedirect("login.jsp");
			}
		}

	}

}
