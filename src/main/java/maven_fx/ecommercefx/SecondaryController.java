package maven_fx.ecommercefx;

import java.io.IOException;

import dao.ProductRepository;
import domain.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondaryController {
	@FXML
	private Label showName;
	@FXML
	private Label showPrice;
	@FXML
	private Label showCurrencyCode;
	@FXML
	private Label showQuantity;
	@FXML
	private Label showExpDate;
	@FXML
	private Label showManufactured;
	@FXML
	private Label showCategory;
	@FXML
	private TextField getIdToFind;
	
    @FXML
    private void backToSaveMenu() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    public void loadFindById() {
    	Product p = ProductRepository.findById(Integer.valueOf(getIdToFind.getText()));
    	
    	if (p != null) {
    		showName.setText(p.getName());
    		showPrice.setText(String.valueOf(p.getPrice().getAmount()));
    		showCurrencyCode.setText(p.getPrice().getCurrency().getCode());
    		showQuantity.setText(String.valueOf(p.getQuantity()));
    		showExpDate.setText(p.getExpiration().toString());
    		showManufactured.setText(p.getManufactured());
    		showCategory.setText(p.getCategory().getName());
    	} else {
    		showName.setText("No product");
    	}
    	
    	
    }
    
    
}