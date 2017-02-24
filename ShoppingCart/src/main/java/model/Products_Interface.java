package model;

import java.util.List;

public interface Products_Interface {
	List<Products> allProducts();

	int updateqty(int product_ID, int newqty);
}
