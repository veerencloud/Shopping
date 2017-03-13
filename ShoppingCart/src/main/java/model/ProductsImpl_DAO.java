package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductsImpl_DAO implements Products_DAO {
	PreparedStatement pst = null;
	Connection con;
	UserLoginImpl_DAO ud = new UserLoginImpl_DAO();

	Connection con_db() {

		return con = ud.connection_db();
	}

	public void productstable_db() {
		try {
			con = con_db();
			pst = con.prepareStatement(
					"create table Products(product_ID number,product_name varchar(20),product_price number,"
							+ "product_qty number)");
			pst.executeQuery();
		} catch (Exception e) {

			System.out.println("Table already created");
		}
	}

	@Override
	public List<Products> allProducts() {

		List<Products> productList = new ArrayList<Products>();

		con = con_db();
		productstable_db();
		try {
			pst = con.prepareStatement("SELECT * FROM Products");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Products p = new Products();
				p.setProduct_ID(rs.getInt("product_ID"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_price(rs.getFloat("product_price"));
				p.setProduct_qty(rs.getShort("product_qty"));
				// System.out.println(p);

				productList.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(productList);
		return productList;
	}

	@Override
	public int updateqty(int product_ID, int newqty) {
		con = con_db();
		int qty = 0;
		try {
			System.out.println("inside update function");
			System.out.println(product_ID);
			pst = con.prepareStatement("update Products set product_qty=? where product_ID = ?");
			pst.setInt(1, newqty);
			pst.setInt(2, product_ID);
			pst.executeUpdate();
			System.out.println("done with update function");

		} catch (Exception e) {
			System.out.println("update qty error"); // e.printStackTrace();

		}
		return qty;
	}

}
