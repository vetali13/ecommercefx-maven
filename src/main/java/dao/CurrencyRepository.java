package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import domain.Money;

public class CurrencyRepository {
	
	public static void addCurrencies() {
		try {
				Statement stm = DBConnection.getConnection().createStatement();
				Money.getCurrencyprovider().getCurrencies().forEach((k,v)->{
					String sql = "INSERT INTO currencies (code,rate) VALUES ('" + k +"'," + v.getRate() + ")";
					try {
						stm.executeUpdate(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});	
		}
		
		catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void addCurrency(String code, double rate) {
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			String sql = "INSERT INTO currencies (code,rate) VALUES ('" + code +"'," + rate + ")";
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
	
	public static String getCodeById(Integer id) {
		String code = null;
		String sql = "SELECT * FROM currencies WHERE id = " + id;
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			if (res.next()) {
				code = res.getString("code");
				return code;
			} else {
				
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return code;
	}
}