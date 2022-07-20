package com.training.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.beans.Statement;
import java.sql.Connection;


public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String userName="scott";
		String password="tiger";
		Connection con= DriverManager.getConnection(url,userName,password);
		Statement stmt = con.createStatement();
		String str="select * from Bank_Application";
		stmt.executeQuery(str) ;
	}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}

}
}
