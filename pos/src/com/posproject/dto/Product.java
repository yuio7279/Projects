package com.posproject.dto;

public class Product {

	String product;
	int stock;
	int price;

	public Product(String p, int s, int pri) {
		this.product = p;
		this.stock = s;
		this.price = pri;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public int getStock() {
		return stock;
	}

	public int getPrice() {
		return price;
	}

}
