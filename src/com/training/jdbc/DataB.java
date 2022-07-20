package com.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataB {

	static Connection con;
	public static Connection getConnection()
	{
	try {
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String pass = "tiger";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection(url, user, pass);
	//System.out.println("Connection Successful!");
	}
	catch (Exception e) {
	System.out.println("Connection Failed!");
	}

	return con;
	}
}

