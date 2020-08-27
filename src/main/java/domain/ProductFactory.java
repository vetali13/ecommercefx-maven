package domain;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ProductFactory {
	
	private static final ProductFactory INSTANCE = new ProductFactory(new ArrayList<>());
	private List<AbstractProduct> products;
	
	private ProductFactory(List<AbstractProduct> products) {
		this.products = products;
	}
	
	
	public AbstractProduct getProduct(String name, Money price, Integer quantity, Date expiration, String manufactured, Category category) {
		AbstractProduct p = new Product(name, price, quantity, expiration, manufactured, category);
		INSTANCE.products.add(p);
		return p;
	}
	
	public void printAllProducts() {
		INSTANCE.products.forEach(System.out::println);
	}
	
	
	public static ProductFactory getProductFactory() {
		return INSTANCE;
	}
	
	public List<AbstractProduct> getAllProducts() {
		return INSTANCE.products;
		}
	
	public Product castProduct(AbstractProduct abstractProduct) {
		return (Product)abstractProduct;
	}
	
}
