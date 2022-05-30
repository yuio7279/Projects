package com.posproject.dto;

public class Buy {
	int buyNo;
	String id;
	String product;
	int stock;
	int price;

	public Buy(int buyNo, String id, String product, int stock, int price) {
		this.buyNo = buyNo;
		this.id = id;
		this.product = product;
		this.stock = stock;
		this.price = price;
	}

	public int getBuyNo() {
		return this.buyNo;
	}

	public String getId() {
		return this.id;
	}

	public String getProduct() {
		return this.product;
	}

	public int getStock() {
		return this.stock;
	}

	public int getPrice() {
		return this.price;
	}

	public void setBuyNo(int buyNo) {
		this.buyNo = buyNo;
	}

	public void setId(String id) {
		this.id = id;
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

}