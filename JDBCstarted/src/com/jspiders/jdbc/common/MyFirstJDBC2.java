 package com.jspiders.jdbc.common;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC2 
{
		public static void main(String[] args) throws FileNotFoundException 
		{
				Connection con = null;
				ResultSet rs = null;
				Statement stmt = null;
				try {
					/*
					 * 1.Load the driver
					 * Driver class: com.mysql.jdbc.driver
					 */
					Driver driverRef = new Driver();
					DriverManager.registerDriver(driverRef);
					
					/*
					 * 2.Get the DB connection via Driver
					 */
					String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db";
					//String userNM = "j2ee";
					//String password = "j2ee";
					FileInputStream stream = new FileInputStream("D:\\property.properties");
					Properties props = new Properties();
					props.load(stream);
				    //String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?"+"user=j2ee&password=j2ee";
					//String dbUrl = "jdbc:mysql://192.168.80.1:3306/studentsapp_db?"+"user=j2ee&password=j2ee";
				
					con = DriverManager.getConnection(dbUrl,props);
					
					/*
					 * 3.Issue SQL Queries via connection
					 */
					
					String query = "select * from student_info";
				    stmt 	= con.createStatement();
				    rs = stmt.executeQuery(query);
				    
				    /*
				     * 4.Process the result returned by SQL Queries
				     */
				    while(rs.next())
				    {
				    	int regno = rs.getInt("regno");
				    	System.out.println("Student Registration Number :"+regno);
				    	String fNM = rs.getString("firstname");
				    	String mNM = rs.getString("middlename");
				    	String lNM = rs.getString("lastname");
				    	System.out.println("first Name : "+fNM);
				    	System.out.println("middle Name : "+mNM);
				    	System.out.println("last Name : "+lNM);
				    	
				    	System.out.println("======================================");
				    	
				    }//End of while
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}finally{
					/*
					 * 5.close All JDBC objects
					 */
					
					try {
						if(con!=null){
							con.close();
						}
						if(rs!=null){
							rs.close();
						}
						if(stmt!=null){
							stmt.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
}