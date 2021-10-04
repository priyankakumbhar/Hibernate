package com.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String args[])
	{
	
	String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
	String username="hbstudent";
	String password="hbstudent";
	try
	{
		System.out.println("Connecting to the database: "+jdbcUrl);
		
		Connection con=DriverManager.getConnection(jdbcUrl,username,password);
		
		System.out.println("Connection succsessful...");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
