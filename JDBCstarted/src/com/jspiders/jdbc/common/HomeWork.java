package com.jspiders.jdbc.common;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class HomeWork 
// we should import all necessary interface or java.sql.*// import java.sql.Connection;
	                                          // DriverManager is a concrete class _import java.sql.DriverManager;
	                                         //import java.sql.ResultSet;
	                                        //import java.sql.SQLException;
	{
		public static void main(String[] args)
		{
		      Connection con=null;
		      PreparedStatement pstmt1 = null;
		      PreparedStatement pstmt2 = null;
		      PreparedStatement pstmt3 = null;
		      
			try
			{
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				String dbUrl="jdbc:mysql://localhost:3306/shanghaai?user=j2ee&password=j2ee";
				con = DriverManager.getConnection(dbUrl);
				
				String query1 = "insert into guardian_info values (?,?,?,?)";
				 pstmt1 = con.prepareStatement(query1);
				 pstmt1.setInt(1,Integer.parseInt(args[0]));
				 pstmt1.setString(2, args[1]);
				 pstmt1.setString(3,args[2]);
				 pstmt1.setString(4,args[3]);
				 int count1 = pstmt1.executeUpdate();
				 
				 
				 String query2 = "insert into student_info values (?,?,?,?)";
				 pstmt2 = con.prepareStatement(query2);
				 pstmt2.setInt(1,Integer.parseInt(args[0])); //called as setxxx methods
				 pstmt2.setString(2, args[4]);
				 pstmt2.setString(3,args[5]);
				 pstmt2.setString(4,args[6]);
				 int count2 = pstmt1.executeUpdate();
				 
				 
				 String query3 = "insert into student_otherinfo values (?,?,?,?)";
				 pstmt3 = con.prepareStatement(query3);
				 pstmt3.setInt(1,Integer.parseInt(args[0]));
				 pstmt3.setString(2, args[7]);
				 pstmt3.setString(3,args[8]);
				 int count3 = pstmt1.executeUpdate();
				 
				 
        System.out.println("_____________________________________");
//				}//END OF while
			}//end of try
			
				catch(SQLException E)
				{
					E.printStackTrace();
				}
			
		//	System.out.println("unable to print the profile");	
      			finally
				{
					try
					{
						if(con!=null)
						{
							con.close();
						}
						if(pstmt1!=null)
						{
							pstmt1.close();
						}
						 
						if(pstmt2!=null)
						{
							pstmt2.close();
						}
						if(pstmt3!=null)
						{
							pstmt3.close();
						}
					
					}
					
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
	}
