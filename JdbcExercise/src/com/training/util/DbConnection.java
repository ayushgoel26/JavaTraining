package com.training.util;

import java.sql.*;
import java.util.*;
import java.io.*;

public class DbConnection {
	
	public static Connection getOracleConnection(){
		
		Connection con = null;
		
		try {
			
			Properties props = new Properties();
			FileInputStream inStream = new FileInputStream(new File("jdbc.properties"));
			
			props.load(inStream);
			Class.forName(props.getProperty("db.driverClass"));
			
			String url = props.getProperty("db.url");
			String user = props.getProperty("db.userName");
			String password = props.getProperty("db.passWord");
			
			con = DriverManager.getConnection(url, user, password);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
}
