package com.rs.fer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	
	
	public static Connection getConnection() {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferjdbc", "root", "flora");
	
		} catch (ClassNotFoundException e) {
					e.printStackTrace();

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					
				}
		return connection;
		}
	public static void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
