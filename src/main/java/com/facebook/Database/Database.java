package com.facebook.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static Connection con;
	
	private static final String Driver="oracle.jdbc.driver.OracleDriver";
	private static final String Url="jdbc:oracle:thin:@LAPTOP-8EILH2SM:1521:XE";
	private static final String User="system";
	private static final String Password="shreysh";
	
	public static Connection getConnection()throws Exception {
	
		
		if(con==null) {
			Class.forName(Driver);
			con=DriverManager.getConnection(Url,User,Password);
			con.setAutoCommit(false);
		}
		return con;
		
	}
	
}

