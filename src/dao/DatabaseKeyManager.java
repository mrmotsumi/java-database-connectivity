package dao;

import java.sql.*;
public class DatabaseKeyManager {
	
	
	public static Connection connect() 
	{
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
		}catch(Exception ex) 
		{
			ex.printStackTrace();
			
		}
		
		
		return conn;
	}
   
}
