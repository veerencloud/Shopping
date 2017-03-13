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

@WebServlet("/ProductCart")
public class ProductCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductsImpl_DAO pd = new ProductsImpl_DAO();

		List<Products> itemslist = pd.allProducts();

		System.out.println(itemslist);
		int newqty;
		int quant = 0;
		float totalcalc;
		List<Float> total = new ArrayList<>();
		List<Integer> qtyall = new ArrayList<>();
		int prodid;
		for (int i = 0; i < itemslist.size(); i++) {
			quant = Integer.parseInt(req.getParameter("product_qty" + i));
			qtyall.add(quant);
			prodid = itemslist.get(i).getProduct_ID();
			newqty = itemslist.get(i).getProduct_qty() - quant;
			pd.updateqty(prodid, newqty);
			totalcalc = quant * itemslist.get(i).getProduct_price();
			total.add(totalcalc);

		}
		System.out.println(total);

		HttpSession session5 = req.getSession();
		session5.setAttribute("total", total);

		HttpSession session6 = req.getSession();
		session6.setAttribute("qtyall", qtyall);

		HttpSession session7 = req.getSession();
		session7.setAttribute("itemslist", itemslist);

		resp.sendRedirect("viewcart.jsp");

	}
}
