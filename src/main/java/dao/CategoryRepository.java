package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryRepository {
	public static void addCategory(String category) {
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			String sql = "INSERT INTO categories (name) VALUES ('" + category +"')";
				try {
					stm.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
	
		catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static String getCategoryById(Integer id) {
		String category = null;
		String sql = "SELECT * FROM categories WHERE id = " + id;
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			if (res.next()) {
				category = res.getString("name");
				return category;
			} else {
				
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return category;
	}
}