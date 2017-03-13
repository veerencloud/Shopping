package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginImpl_DAO implements User_DAO {

	PreparedStatement pst = null;
	Connection con;
	User u = new User();

	public Connection connection_db() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "c##madhumitha", "Connect14");

			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void createtable_db() {
		try {
			String st = "create table Users(Firstname varchar(20), Lastname varchar(20),UserName varchar(20),Password varchar(20))";
			pst = con.prepareStatement(st);
			pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Table already created");
		}
	}

	@Override
	public void newuser(String firstname, String lastname, String userName, String password) {
		try {
			connection_db();
			createtable_db();
			pst = con.prepareStatement("insert into Users (Firstname, Lastname, UserName, Password) values(?,?,?,?)");
			pst.setString(1, firstname);
			pst.setString(2, lastname);
			pst.setString(3, userName);
			pst.setString(4, password);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("newuser method");
		}

	}

	@Override
	public User getuser(String UserName) {
		User u = new User();
		connection_db();
		try {
			pst = con.prepareStatement("SELECT * from Users where UserName=?");
			pst.setString(1, UserName);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				u.setFirstname(rs.getString(1));
				u.setLastname(rs.getString(2));
				u.setPassword(rs.getString(4));
				u.setUserName(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getuser method");
		}
		return u;

	}

}
