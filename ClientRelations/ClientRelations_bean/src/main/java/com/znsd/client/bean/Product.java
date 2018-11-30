package com.znsd.client.bean;

public class Product {
	private Integer productId;//商品id
	private String productName;//商品名称
	private String productTypeNumber;//商品型号
	private double price;//单价
	private Integer productNumber;//商品库存数量
	private int number;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductTypeNumber() {
		return productTypeNumber;
	}
	public void setProductTypeNumber(String productTypeNumber) {
		this.productTypeNumber = productTypeNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productTypeNumber="
				+ productTypeNumber + ", price=" + price + ", productNumber=" + productNumber + "]";
	}
	
}
