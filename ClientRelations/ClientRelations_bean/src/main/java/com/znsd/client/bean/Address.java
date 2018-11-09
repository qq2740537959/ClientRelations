package com.znsd.client.bean;

import java.io.Serializable;


/**
 * The persistent class for the address database table.
 * 
 */

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int clientId;
	private String consigneeName;
	private int phone;
	private String shippingAddress;

	public Address() {
	}


	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	
	public String getConsigneeName() {
		return this.consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}


	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	
	public String getShippingAddress() {
		return this.shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}