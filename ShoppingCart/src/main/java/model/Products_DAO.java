package model;

import java.util.List;

public interface Products_DAO {
	List<Products> allProducts();

	int updateqty(int product_ID, int newqty);
}
