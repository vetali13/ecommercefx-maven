package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import domain.Category;
import domain.Money;
import domain.Product;
import domain.ProductFactory;

public class ProductRepository {
	
	public static void createEntry(Product product) {
		String name = product.getName();
		Float price = product.getPrice().getAmount();
		Integer currency_id = getCurrencyId(product.getPrice().getCurrency().getCode());
		Date expiration = product.getExpiration();
		Integer manufactured_id = getManufacturedId(product.getManufactured());
		Integer category_id = getCategoryId(product.getCategory().getName());
		Integer quantity = product.getQuantity();
		
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			String sql = "INSERT INTO products (name,price,currency_id,expiration,manufactured_id,category_id,quantity) "
					+ "VALUES ('" + name +"'," + price + "," + currency_id + ",'" + expiration + "'," + manufactured_id + "," + 
					category_id + "," + quantity +")";
			try {
				stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Integer getCurrencyId(String code){
		String select = "SELECT id FROM currencies WHERE code = " + "'" + code + "';";
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			ResultSet res = stm.executeQuery(select);
			if (res.next() == false) {
				System.out.println("No such currency code!");
				return null;
			} else {
				return res.getInt("id");
			}
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	public static Integer getManufacturedId(String manufactured){
		String select = "SELECT id FROM manufacturers WHERE manufactured = " + "'" + manufactured + "';";
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			ResultSet res = stm.executeQuery(select);
			if (res.next() == false) {
				ManufacturedRepository.addManufactured(manufactured);
				ResultSet res_new = stm.executeQuery(select);
				res_new.next();
				return res_new.getInt("id");
			} else {
				return res.getInt("id");
			}
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	public static Integer getCategoryId(String category){
		String select = "SELECT id FROM categories WHERE name = " + "'" + category + "';";
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			ResultSet res = stm.executeQuery(select);
			if (res.next() == false) {
				CategoryRepository.addCategory(category);
				ResultSet res_new = stm.executeQuery(select);
				res_new.next();
				return res_new.getInt("id");
			} else {
				return res.getInt("id");
			}
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	public static Product findById(Integer id) {
		Product product = null;
		String sql = "SELECT * FROM products WHERE id = " + id;
		try {
			Statement stm = DBConnection.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			
			if (res.next()) {
				String name = res.getString("name");
				Money price = new Money(
										CurrencyRepository.getCodeById(res.getInt("currency_id")),
										Float.valueOf(res.getFloat("price"))
										);
				Integer quantity = res.getInt("quantity");
				Date expiration = res.getDate("expiration");
				String manufactured = ManufacturedRepository.getManufacturedById(res.getInt("manufactured_id"));
				Category category = new Category(CategoryRepository.getCategoryById(res.getInt("category_id")));
				
				Product p = (Product) ProductFactory.getProductFactory().getProduct(name, price, quantity, expiration, manufactured, category);
				
				return p;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		return product;
	}

}
