package domain;

import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class Money implements Serializable{
	private Currency currency;
	private Float amount;
	private static final CurrencyProvider currencyProvider = new CurrencyProvider(new HashMap<String, Currency>(){{
	       put("EUR",new Currency("EUR", 1.00));
	       put("USD",new Currency("USD", 1.11));
	       put("MDL",new Currency("MDL", 19.25));
	       put("RUB",new Currency("RUB", 80.00));
	       put("RON",new Currency("RON", 4.5));
	       }});
	
	public Money toCurrency(String code) {
		Float amountInEur = (float)( this.getAmount() / currencyProvider.
													getCurrency(this.getCurrency().getCode()).
													getRate() ) ;
		Float newAmount = amountInEur * (float)(currencyProvider.
												getCurrency(code).getRate());
		return new Money(code, newAmount);
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currencyProvider.getCurrency(currency);
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	public Money(String currency, Float amount) {
		this.currency = currencyProvider.getCurrency(currency);
		this.amount = amount;
	}
	@Override
	public String toString() {
		return amount + " " + currency;
	}
	public static CurrencyProvider getCurrencyprovider() {
		return currencyProvider;
	}
	
	
	
}