package domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Category(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category: " + name;
	}

}