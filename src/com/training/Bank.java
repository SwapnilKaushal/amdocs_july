package com.training;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.training.jdbc.New_Account;
import com.training.jdbc.randomn;

public class Bank  {
	
	public static void main(String[] args) {
		System.out.println("-----Welcome to Bank Application-----");
		System.out.println("-----New User Press 1 -----");
		System.out.println("-----Existing User Press 2 -----");
		
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		
		if(num==1) {
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String userName="scott";
			String password="tiger";
			Connection con= DriverManager.getConnection(url,userName,password);
			
			String acc="INSERT INTO CUSTOMER_DETAILS (NAME,CITY,PHONE,AADHAR,BALANCE,ACCNO) VALUES (?,?,?,?,?,?)";
			Scanner sc=new Scanner(System.in);
			String name;
			String city;
			 long phone;
			 long aadhar;
			long balance;
			

				
				
		        System.out.println("Enter Name: "); 
		        name = sc.nextLine();  
		        System.out.println("Enter City: ");  
		        city = sc.next();  
		        System.out.println("Enter Phone Number: ");  
		        phone = sc.nextLong();
		        System.out.println("Enter Aadhar Number: ");  
		        aadhar = sc.nextLong();
		        System.out.println("Enter Balance: ");  
		        balance = sc.nextLong();
		        
		       
		        New_Account obj=new New_Account();
		        long facc=obj.generateAcc();
		        System.out.println("Acc no is : "+facc);
		        
		        
			PreparedStatement st = con.prepareStatement(acc);
			st.setString(1, name);
			st.setString(2, city);
			st.setLong(3, phone);
			st.setLong(4, aadhar);
			st.setLong(5, balance);
			st.setLong(6, facc);
			
			int i=st.executeUpdate();
			System.out.println(".... Account Created Successfully ....");
			
			st.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			
			
		}
	}

}
