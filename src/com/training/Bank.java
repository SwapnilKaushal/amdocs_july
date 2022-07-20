package com.training;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.dom.AbortException;
import com.training.jdbc.DataB;
import com.training.jdbc.New_Account;
import com.training.jdbc.OldAcc;
import com.training.jdbc.randomn;

public class Bank  {
	
	public static void main(String[] args) {
		System.out.println("----- Welcome to Bank Application -----");
		System.out.println("----- New User Press 1 -----");
		System.out.println("----- Existing User Press 2 -----");
		
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
			Connection con=DataB.getConnection();
			Scanner a=new Scanner(System.in);
			System.out.println(".... Enter your Account Number ....");
			long tempacc=a.nextLong();
			try {
				String q = "select * from CUSTOMER_DETAILS where ACCNO=?";
				PreparedStatement st = con.prepareStatement(q);
				st.setLong(1, tempacc);
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
				System.out.print("ACCOUNT NUMBER:"+rs.getLong("ACCNO")+"\nNAME:"+ rs.getString("NAME")+"\nBALANCE: "+ rs.getLong("BALANCE")+"\n");
				
				System.out.print("If you want to Deposit Funds press 1 \nIf you want to Withdraw Funds press 2 \nPress 3 to exit\n");
				
				int num1=s.nextInt();
				
				
				if(num1==1) {
					try {
					String q1 = "select ACCNO,BALANCE from CUSTOMER_DETAILS where ACCNO=?";
					PreparedStatement st1 = con.prepareStatement(q1);
					st1.setLong(1, tempacc);
					ResultSet rs1=st1.executeQuery();
			        if(rs1.next()) {
					long bal=rs1.getLong("BALANCE");
					 long amt;  
				        System.out.println("Enter the amount you want to deposit: ");  
				        amt = a.nextLong();  
				        bal = bal + amt;
				       // System.out.println("New Balance:"+bal);
				      
				        st1=con.prepareStatement("UPDATE CUSTOMER_DETAILS SET BALANCE=? WHERE ACCNO=? ");
				        st1.setLong(1, bal);
				        st1.setLong(2, tempacc);
				        st1.executeUpdate();
				        System.out.println("Updated Balance : "+bal);
			        }
					}catch(SQLException e) {
						e.printStackTrace();
					}
				        
				}
				
				
				else if(num1==2) {
					try {
						String q1 = "select ACCNO,BALANCE from CUSTOMER_DETAILS where ACCNO=?";
						PreparedStatement st1 = con.prepareStatement(q1);
						st1.setLong(1, tempacc);
						ResultSet rs1=st1.executeQuery();
				    
						if(rs1.next()) {
						long bal=rs1.getLong("BALANCE");
						 long amt;  
					        System.out.println("Enter the amount you want to withdraw: ");  
					        amt = a.nextLong();  
					        bal = bal - amt;
					    
					        st1=con.prepareStatement("UPDATE CUSTOMER_DETAILS SET BALANCE=? WHERE ACCNO=? ");
					        st1.setLong(1, bal);
					        st1.setLong(2, tempacc);
					        st1.executeUpdate();
					        System.out.println("Updated Balance : "+bal);
				        }
						}catch(SQLException e) {
							e.printStackTrace();
						}
				}
				
				
				else {
					System.out.println("THANK YOU USING OUR SERVICES");
				}
				}
				else {
				System.out.println("Invalid account number");
				}
			}
				
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
