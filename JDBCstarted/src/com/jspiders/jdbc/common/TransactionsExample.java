package com.jspiders.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class TransactionsExample 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try 
		{
			//1. Load the Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2. Get the DB Connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			/*
			 * I. Begin the Transaction
			 */
			con.setAutoCommit(false);
			
			/*
			 * II. Issue One/More SQL Queries
			 */
			//3. Issue SQL Queries via Connection 
			
			String query1 = " insert into student_info " 
					  		+" values (?, ?, ?, ?) ";
			
			pstmt1 = con.prepareStatement(query1);
			pstmt1.setInt(1, Integer.parseInt(args[0]) );
			pstmt1.setString(2, args[1]);
			pstmt1.setString(3, args[2]);
			pstmt1.setString(4, args[3]);
			int count1 = pstmt1.executeUpdate();
			
			String query2 = " insert into guardian_info " 
			  				+" values (?, ?, ?, ?) ";
	
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setInt(1, Integer.parseInt(args[0]) );
			pstmt2.setString(2, args[4]);
			pstmt2.setString(3, args[5]);
			pstmt2.setString(4, args[6]);
			int count2 = pstmt2.executeUpdate();
			
			/*
			 * Error Simulation
			 */
			//int i = 100/0;
			
			String query3 = " insert into student_otherinfo " 
	  						+" values (?, ?, ?) ";

			pstmt3 = con.prepareStatement(query3);
			pstmt3.setInt(1, Integer.parseInt(args[0]) );
			pstmt3.setString(2, args[7]);
			pstmt3.setString(3, args[8]);
			int count3 = pstmt3.executeUpdate();
			
			/*
			 * III. No Error; Commit the Txn
			 */
			con.commit();
			
			//4. Process the results
			System.out.println("Successfully Created the Profile ...");
			System.out.println("No. of Rows Affected for S_I : "+count1);
			System.out.println("No. of Rows Affected for G_I : "+count2);
			System.out.println("No. of Rows Affected for S_OI : "+count3);
			
		} 
		catch (Exception e) 
		{
			/*
			 * IV. Error !!! Rollback
			 */
			try 
			{
				con.rollback();
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.err.println("Unable to Create the Profile !!! Pls try later ");
			e.printStackTrace();
		} 
		finally
		{
			//5. Close ALL JDBC Objects
			try 
			{
				if(con!=null){
					con.close();
				}
				if(pstmt1!=null){
					pstmt1.close();
				}
				if(pstmt2!=null){
					pstmt2.close();
				}
				if(pstmt3!=null){
					pstmt3.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of Main
}//End of Class
