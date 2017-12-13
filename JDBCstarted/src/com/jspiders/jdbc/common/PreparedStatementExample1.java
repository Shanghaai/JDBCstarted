package com.jspiders.jdbc.common;

import java.sql.*;

import com.mysql.jdbc.Driver;
public class PreparedStatementExample1 
{
	// we should import all necessary interface// import java.sql.Connection;
	                                          // DriverManager is a concrete class _import java.sql.DriverManager;
	                                         //import java.sql.ResultSet;
	                                        //import java.sql.SQLException;
	                                       //import java.sql.Statement;
		public static void main(String[] args) 
		{
		      Connection con=null;
			  PreparedStatement pstmt=null;
			  ResultSet rs=null;
			try
			{
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				String dbUrl="jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
				con = DriverManager.getConnection(dbUrl);
				
				String query = "select * from student_info where regno = ? and firstname = ?";
				 
				 pstmt = con.prepareStatement(query);
				 String regno = args[0];
				 String firstNM = args[1];
				 //chnaging String type regno into int 
				 int regNM = Integer.parseInt(regno);
				 pstmt.setInt(1,regNM);
				 pstmt.setString(2,firstNM);
				 
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					int Regno = rs.getInt("regno");
					String fNM = rs.getString("firstname");
					String mNM = rs.getString("middlename");
					String lNM = rs.getString("lastname");
					
					System.out.println("Registration Number:"+Regno);
					System.out.println("First name:"+fNM);
					System.out.println("Middle Name:"+mNM);
					System.out.println("LAST Name:"+lNM);
					System.out.println("_____________________________________");
				}//END OF while
				
				
			
			}//end of try
			
				catch(SQLException E)
				{ 
					System.err.println("unable to find Regno");
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
						if(pstmt!=null)
						{
							pstmt.close();
					    } 
					}
					
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
	}
