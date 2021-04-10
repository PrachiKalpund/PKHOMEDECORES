package com.pkhomedecores.utility;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBUtility 
	{
	public static Connection connection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/homedecores","root","");	
			/*
			 * String url="jdbc:mysql://localhost:3306/javaproject"; String user="root";
			 * String pass=""; con = DriverManager.getConnection(url,user,pass);
			 */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
