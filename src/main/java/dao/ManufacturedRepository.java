package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManufacturedRepository {
	public static void addManufactured(String manufactured) {

		try {
			Statement stm = DBConnection.getConnection().createStatement();
			String sql = "INSERT INTO manufacturers (manufactured) VALUES ('" + manufactured +"')";
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
	
	public static String getManufacturedById(Integer id) {
		String manufactured = null;
		String sql = "SELECT * FROM manufacturers WHERE id = " + id;
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			if (res.next()) {
				manufactured = res.getString("manufactured");
				return manufactured;
			} else {
				
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return manufactured;
	}
}