package model;

public class User {

	private String Firstname, Lastname, UserName, Password, ConfirmPassword;

	public User() {

	}

	public User(String firstname, String lastname, String userName, String password, String confirmPassword) {
		super();
		Firstname = firstname;
		Lastname = lastname;
		UserName = userName;
		Password = password;
		ConfirmPassword = confirmPassword;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirmPassword() {
		return ConfirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}

}
