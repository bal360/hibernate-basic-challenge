package com.blakelong.hibernate.challenge.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_employee_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbemployees";		
		String pass = "hbemployees";
		
		try {
			System.out.println("Connection to database: " + jdbcUrl);
			
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pass);	
			
			System.out.println("Connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
