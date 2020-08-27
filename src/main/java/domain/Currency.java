package domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Currency implements Serializable{
		public static Currency baseCurrency = new Currency ("EUR", 1.00); 
	    private String code;
	    private double rate;
	    
		public Currency(String code, double rate) {
			this.code = code;
			this.rate = rate;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		@Override
		public String toString() {
			return code + " (exchange rate " + code + " to EUR " + rate + ")";
		}
}