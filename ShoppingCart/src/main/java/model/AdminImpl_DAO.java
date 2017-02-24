package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminImpl_DAO implements Admin_Interface {

	PreparedStatement pst=null;
	Connection con;
	UserLogin_DAO ud= new UserLogin_DAO();



	@Override
	public void getuser(String UserName) {
		User u=new User();
		con=ud.connection_db();
		try{
		pst=con.prepareStatement("SELECT * from Users");
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			u.setFirstname(rs.getString(1));
			u.setLastname(rs.getString(2));
			u.setPassword(rs.getString(4));
			u.setUserName(rs.getString(3));
			allusers();
		}
		
	}catch(Exception e){e.printStackTrace(); System.out.println("getuser method");}
		
	}



	@Override
	public List<User> allusers() {
		List <User> userList=new ArrayList<User>();
		
		User u=new User();
		ud.connection_db();
		try{
		pst=con.prepareStatement("SELECT * FROM Users");
		ResultSet rs= pst.executeQuery();
		while(rs.next()){
			u.setFirstname(rs.getString("FirstName"));
			u.setLastname(rs.getString("LastName"));
			u.setUserName(rs.getString("UserName"));
			u.setPassword(rs.getString("Password"));
			userList.add(u);
			
		}
		
		}catch(Exception e){System.out.println("Exception found");e.printStackTrace();System.out.println("allusers");}
				
		return userList;
	}



	@Override
	public void adminedit(int product_ID, String product_name, float product_price, int product_qty) {
		con=ud.connection_db();
		Products_DAO pd= new Products_DAO();
		try{
			pd.productstable_db();
			System.out.println(product_ID);
			System.out.println(product_name);
			System.out.println(product_price);
			System.out.println(product_qty);
			pst=con.prepareStatement("update Products set product_name=?,product_price=?, product_qty=? where product_ID = ?");
			pst.setString(1,product_name);
			pst.setFloat(2, product_price);
			pst.setInt(3, product_qty);
			pst.setInt(4, product_ID);
			pst.executeUpdate();
					
		}catch(Exception e){ System.out.println("insert error");  e.printStackTrace();
		
	}
		
	}



	@Override
	public void addprod(int product_ID, String product_name, float product_price, int product_qty) {
		try{
			Products_DAO pd= new Products_DAO();
			con=ud.connection_db();
			pd.productstable_db();
			pst=con.prepareStatement("insert into Products (product_ID, product_name, product_price, product_qty) values(?,?,?,?)");			
			pst.setInt(1, product_ID);
			pst.setString(2, product_name);
			pst.setFloat(3, product_price);
			pst.setInt(4, product_qty);
			pst.executeUpdate();
			
			}catch(Exception e){e.printStackTrace(); System.out.println("newprod method");}
					
		
	}



	@Override
	public void deleteprod(int product_ID) {
		try{
		Products_DAO pd= new Products_DAO();
		con=ud.connection_db();
		pd.productstable_db();
		pst=con.prepareStatement("delete Products where product_ID=?");			
		pst.setInt(1, product_ID);
		pst.executeUpdate();
		}catch(Exception e){e.printStackTrace(); System.out.println("delete method");}
	}

	


}
