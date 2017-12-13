package com.jspiders.jdbc.common;
// we should import all necessary interface or java.sql.*
                                          // import java.sql.Connection;
                                         //  import java.sql.ResultSet;
                                        //   import java.sql.SQLException;
                                       //    import java.sql.Statement;

import java.sql.*;
import java.util.List;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC
{
	public static void main(String[] args) 
	{
	      Connection con=null; //java.sql.connection is a interface
	      Statement stmt=null;
	      ResultSet rs=null;
		  
		try
		{
			//1.LOAD THE Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);  
			// DriverManager is a concrete class _import java.sql.DriverManager AND is singleton in nature i.e. one privtae constructor and static method;
			
			//2.Get The Connection
			String dbUrl="jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			//3.Issue SQL query
			String query = "delete guardian_info where regno=111";
			 stmt = con.createStatement();
			 int update  = stmt.executeUpdate(query);
		     
			 System.out.println("update success : "+update);
			 /*rs = stmt.executeQuery(query);
			
		    //4.Process the result return by SQL query 
			while(rs.next())
			{
				int regno  = rs.getInt("regno");
				String fNM = rs.getString("firstname");
				String mNM = rs.getString("middlename");
				String lNM = rs.getString("lastname");
				
				System.out.println("Registration Number:"+regno);
				System.out.println("First name:"+fNM);
				System.out.println("Middle Name:"+mNM);
				System.out.println("LAST Name:"+lNM);
				System.out.println("_____________________________________");
			}//END OF while
			System.out.println("Exception occurs here....");
			getSqlForTab();*/
		}//end of try
		
			catch(Exception E)
			{
				System.out.println("Exception occurs here....");
				//E.printStackTrace();
				System.out.println("Exception is :"+E.getMessage());
			}
		
			//5.Close all JDBC Object
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
					//e.printStackTrace();
					//System.out.println("Exception is :"+e.getMessage());
				}
			}
		}
	
	
	public static void getSqlForTab() {
		String beats = null;
		String audio = "";
		if (beats.equals(audio)) {
			System.out.println("see" + "''" + " is equal to null ");
		}

	}
	
	
	
}
