package domain;

import java.util.HashMap;
import java.util.Map;

public class CurrencyProvider {
	
	private Map<String,Currency> currencies;
	
	public CurrencyProvider(HashMap<String, Currency> currencies) {
		this.currencies = currencies;
	}

	public Currency getCurrency(String code) {
		return this.currencies.get(code);
	}

	public Map<String, Currency> getCurrencies() {
		return currencies;
	}
	
}
