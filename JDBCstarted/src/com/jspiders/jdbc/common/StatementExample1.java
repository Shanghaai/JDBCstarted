package com.jspiders.jdbc.common;
//we should upload all necessary interface// import java.sql.Connection;

// DriverManager is a concrete class _import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;

import com.mysql.jdbc.Driver;

public class StatementExample1 
{
		public static void main(String[] args) 
		{
		      Connection con=null;
			  ResultSet rs=null;
			  Statement stmt=null;
			try
			{
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				String dbUrl="jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
				con = DriverManager.getConnection(dbUrl);
				
				String query = "insert into student_info values (9,'Navi Bhai','Firozbad','NA')";
				 stmt = con.createStatement();
			     int count = stmt.executeUpdate(query);
			     System.out.println("affected count:"+count);
	
			     /*while(rs.next())
				{
					int regno = rs.getInt("regno");
					String fNM = rs.getString("firstname");
					String mNM = rs.getString("middlename");
					String lNM = rs.getString("lastname");
					
					System.out.println("Registration Number:"+regno);
					System.out.println("First name:"+fNM);
					System.out.println("Middle Name:"+mNM);
					System.out.println("LAST Name:"+lNM);
					System.out.println("affected count:"+count);
					System.out.println("_____________________________________");
					System.out.println("affected count:"+count);
				}//END OF while
			      */			
			 }//end of try
			
				catch(SQLException E)
				{
					E.printStackTrace();
				}
				finally
				{
					try
					{
						if(con!=null)
						{
							con.close();
						}
						if(rs!=null)
						{
							rs.close();
						}
						if(stmt!=null)
						{
							stmt.close();
					    } 
					}
					
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
	}
