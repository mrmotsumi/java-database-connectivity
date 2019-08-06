package dao;

import model.Student;
import java.sql.*;
import java.util.*;
public class StudentDao {
	
	static Connection conn =null;
	static PreparedStatement ps;
	static ResultSet rs;
	// inserting record
	
	public static void insertData(Student student) 
	{
		
		conn =  DatabaseKeyManager.connect();
		
		String sql = "INSERT INTO STUDENT(NAME,GENDER) VALUES(?,?)";
		
		try 
		{
			if(conn != null) {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getGender());
			
			if(ps.executeUpdate() >0) 
			{
				System.out.println("Record Inserted");
			}else 
			{
				System.out.println("Record failed to be Inserted");

			}
		}

		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	//read records
	
	public static List<Student> getAll()
	{
		List<Student> list = new ArrayList<>();
		Student st = null;
		
		conn =  DatabaseKeyManager.connect();
		String sql = "select * from student";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				st = new Student();
			    st.setId(rs.getInt("ID"));
				st.setName(rs.getString("NAME"));
				st.setGender(rs.getString("GENDER"));
				
				list.add(st);
				
			}
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
		return list;
		
	}

  //update record
	public static void updateRecord(Student student) 
	{
		conn =  DatabaseKeyManager.connect();
		String sql = "UPDATE STUDENT SET NAME=?, GENDER=? WHERE ID=?";
		
		try 
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getGender());
			ps.setInt(3, student.getId());
			
			if(ps.executeUpdate() > 0) 
			{
				System.out.println("Record Updated ");
			}else 
			{
				System.out.println("Record Could Not Be Updated ");

			}


			
		}catch(Exception ex) {}


	}
	

	//delete record
	public static void deleteDelete(int id) 
	{
		conn = DatabaseKeyManager.connect();
		
		String sql = "DELETE FROM STUDENT WHERE ID=?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i > 0) 
			{
				System.out.println("Record has been removed");
			}
			else 
			{
				System.out.println("No Record Removed");
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
}
