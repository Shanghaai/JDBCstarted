package com.jspiders.jdbc.common;
import java.sql.*;

import com.mysql.jdbc.Driver;

public class CallableStatementExample
	{
			public static void main(String[] args) 
			{
			      Connection con = null;
				  ResultSet rs = null;
				  Statement stmt = null;
				try
				{
					Driver driverRef=new Driver();
					DriverManager.registerDriver(driverRef);
					
					String dbUrl="jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(dbUrl);
				
					
				//  String query = "create database temp123";
				//	String query = "drop database temp123";
					String query = "select * from student_info";
				//	String query = "drop database temp123";
					
					 stmt = con.createStatement();
					 
				     boolean isDBresult = stmt.execute(query);
				     
					
					if(isDBresult)
					{
						int count;
						System.out.println("Result is of type db result");
						ResultSet rs1 = stmt.getResultSet();
						
						while(rs1.next())
					{
						int regno = rs1.getInt("regno");
						String fNM = rs1.getString("firstname");
						String mNM = rs1.getString("middlename");
						String lNM = rs1.getString("lastname");
						
						System.out.println("Registration Number:"+regno);
						System.out.println("First name:"+fNM);
						System.out.println("Middle Name:"+mNM);
						System.out.println("LAST Name:"+lNM);
						System.out.println("_____________________________________");
					}//END OF while
					//System.out.println("total affected rows:"+count);
				
				 }//end of try
				else
				{
					System.out.println("not a db result its a int count type");
					int count = stmt.getUpdateCount();
					System.out.println("rows affetcted count:"+count);
				}
			}
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
 