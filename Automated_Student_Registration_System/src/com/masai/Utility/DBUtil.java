package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	static String drivername;
	static String url;
	static String username;
	static String password;
	static {
		ResourceBundle rs =  ResourceBundle.getBundle("dbdetails");
		drivername = rs.getString("drivername");
		url = rs.getString("url");
		username = rs.getString("username");
		password = rs.getString("password");
	}
	
	public static Connection provideConnection() {
		Connection con = null;
		
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
