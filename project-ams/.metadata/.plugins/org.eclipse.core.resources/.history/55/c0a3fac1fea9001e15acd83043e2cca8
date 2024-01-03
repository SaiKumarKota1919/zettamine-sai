package com.zm.ams.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcConnectionFactory {
	private static Connection connection =null;
	public static Connection getJdbcConnection() {
		
		if(connection==null)
		{
			ResourceBundle resourceBundle = ResourceBundle.getBundle("com.zm.ams.config.jdbc-config");
			String driverClass = resourceBundle.getString("jdbc.driverclass");
			String url = resourceBundle.getString("jdbc.url");
			String user = resourceBundle.getString("jdbc.user");
			String password = resourceBundle.getString("jdbc.password");
			
			try {
				Class.forName(driverClass);
				connection = DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			
		}
		
			return connection;
		
		
	}

}
