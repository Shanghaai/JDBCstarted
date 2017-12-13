package com.jspiders.jdbc.common;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
public class Assignment1 
{
	public static void main(String[] args) 
	{
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	
	try
	{
		
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?"+"user=j2ee&password=j2ee";
	con = DriverManager.getConnection(dbUrl);
	
//	 String query =" insert into student_info "
//				+"values(?,?,?,?)";
//	 
//		pstmt =con.prepareStatement(query);
//		pstmt.setInt(1,Integer.parseInt(args[0]));
//		pstmt.setString(2, args[1]);
//		pstmt.setString(3, args[2]);
//		pstmt.setString(4, args[3]);
//		int count=pstmt.executeUpdate();
//		
	String query1 =" insert into guardian_info "
			+"values(?,?,?,?)";
	
	pstmt1 =con.prepareStatement(query1);
	pstmt1.setInt(1,Integer.parseInt(args[0]));
	pstmt1.setString(2, args[4]);
	pstmt1.setString(3, args[5]);
	pstmt1.setString(4, args[6]);
	int count1=pstmt1.executeUpdate();
	
	String query2 =" insert into student_otherinfo "
			+"values(?,?,?)";
	
	pstmt2 =con.prepareStatement(query2);
	pstmt2.setInt(1,Integer.parseInt(args[0]));
	pstmt2.setString(2, args[7]);
	pstmt2.setString(3, args[8]);

	int count2=pstmt2.executeUpdate();
	System.out.println("count");
	
} 
catch (SQLException e) 
{
	System.err.println("Unable to create the profile!");
	e.printStackTrace();
}

finally
{
	/*
	 * 5.close All JDBC objects
	 */
	
	try 
	{
		if(con!=null){
			con.close();
		}
		
		
		if(pstmt!=null){
			pstmt.close();
		}
		if(pstmt1!=null){
			pstmt1.close();
		}
		if(pstmt2!=null){
			pstmt2.close();
		}
	} 
	catch (SQLException e)
	{
		e.printStackTrace();
    }
  }
 }

}
