package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url = "jdbc:postgresql://localhost/ecommerce?user=postgres&password=postgres&ssl=false";
	private static final Connection db_connect = connectTo(url);
	
	private static Connection connectTo(String url) {
		
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection() {
		return db_connect;
	}
}