package com.trg.oracle.springjdbcapp;

public class Product {
	private int productId;
	private String name;
	private double price;
	public Product(int productId, String name, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductId=" + productId + ", name=" + name + ", price=" + price ;
	}

	
}
