package model;

public interface User_DAO {

	void newuser(String firstname, String lastname, String userName, String password);

	User getuser(String UserName);
}
