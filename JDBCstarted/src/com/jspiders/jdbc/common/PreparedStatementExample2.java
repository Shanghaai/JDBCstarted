package com.jspiders.jdbc.common;
import java.sql.*;

import com.mysql.jdbc.Driver;
public class PreparedStatementExample2 {
		// we should upload all necessary interface// import java.sql.Connection;
		                                          // DriverManager is a concrete class _import java.sql.DriverManager;
		                                         //import java.sql.ResultSet;
		                                        //import java.sql.SQLException;
		                                       //import java.sql.Statement;
			@SuppressWarnings("null")
			public static void main(String[] args) 
			{
			      Connection con=null;
				  ResultSet rs=null;
				  PreparedStatement pstmt=null;
				try
				{
					Driver driverRef=new Driver();
					DriverManager.registerDriver(driverRef);
					
					String dbUrl="jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(dbUrl);
					
					String query = "insert into student_info values (?,?,?,?)";
					 pstmt = con.prepareStatement(query);
					 
					 pstmt.setInt(1, Integer.parseInt(args[0]));
					 pstmt.setString(2,args[1]);
					  pstmt.setString(3,args[2]);
					 pstmt.setString(4,args[3]);
					 
					 int count = pstmt.executeUpdate();	
					
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
						System.out.println(" total count is :"+count);
					}//END OF while
					
					System.out.println("successfully created the profile");
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
