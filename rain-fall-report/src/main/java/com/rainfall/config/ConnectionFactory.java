package com.rainfall.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

	private static Connection connection=null;
	
	public static Connection getJdbConnection() throws ClassNotFoundException, SQLException {
		if(connection==null) {
			
			ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc-config");
			
			String driverClass = resourceBundle.getString("jdbc.driverclass");
			String url = resourceBundle.getString("jdbc.url");
			String user = resourceBundle.getString("jdbc.user");
			String password =resourceBundle.getString("jdbc.password");
			 
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url,user,password);
			
		}
		return connection;
		
	}
	
}
