package model;

import java.util.List;

public interface Admin_Interface {

	void getuser(String UserName);

	List<User> allusers();
	
	void adminedit(int product_ID, String product_name, float product_price, int product_qty);
	
	void addprod(int product_ID, String product_name, float product_price, int product_qty);
	
	void deleteprod(int product_ID);

}
