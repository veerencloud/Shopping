package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserLogin_DAO;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserLogin_DAO ud = new UserLogin_DAO();
		String Firstname = req.getParameter("Firstname");
		String Lastname = req.getParameter("Lastname");
		String UserName = req.getParameter("UserName");
		String Password = req.getParameter("Password");
		String ConfirmPassword = req.getParameter("ConfirmPassword");

		if (!(ConfirmPassword.equals(Password))) {
			System.out.println("The passwords dont match");
			resp.sendRedirect("register.jsp");
		} else {
			ud.newuser(Firstname, Lastname, UserName, Password);
			resp.sendRedirect("login.jsp");

			HttpSession session = req.getSession();
			session.setAttribute("UserName", UserName);
		}

	}

}
