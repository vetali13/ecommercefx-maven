package maven_fx.ecommercefx;

import java.io.IOException;
import java.sql.Date;

import dao.ProductRepository;
import domain.Category;
import domain.Money;
import domain.Product;
import domain.ProductFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

	@FXML
	private TextField inputName;
	@FXML
	private TextField inputPrice;
	@FXML
	private TextField inputCurrencyCode;
	@FXML
	private TextField inputQuantity;
	@FXML
	private TextField inputExpDate;
	@FXML
	private TextField inputManufactured;
	@FXML
	private TextField inputCategory;
	
	
    @FXML
    private void goToLoadMenu() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void saveProduct() throws Exception {
    	String name = inputName.getText();
		Money price = new Money(
								inputCurrencyCode.getText(),
								Float.valueOf(inputPrice.getText())
								);
		Integer quantity = Integer.valueOf(inputQuantity.getText());
		Date expiration = Date.valueOf(inputExpDate.getText());
		String manufactured = inputManufactured.getText();
		Category category = new Category(inputCategory.getText());
		
		Product p = (Product) ProductFactory.getProductFactory().getProduct(name, price, quantity, expiration, manufactured, category);
		
		ProductRepository.createEntry(p);
		
			inputName.clear();
			inputPrice.clear();
			inputCurrencyCode.clear();
			inputQuantity.clear();
			inputExpDate.clear();
			inputManufactured.clear();
			inputCategory.clear();
    }
}