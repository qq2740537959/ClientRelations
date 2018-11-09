package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the order_indent database table.
 * 
 */


public class OrderIndent implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private double carriage;
	private String commercialVoucher;
	private String commodity;
	private int commodityNumber;
	private Date dealTime;
	private String modeOfDistribution;
	private String modeOfPayment;
	private String orderCode;
	private double orderMoney;
	private String orderStatus;
	private String orderType;
	private int shippingAddressId;

	public OrderIndent() {
	}


	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public double getCarriage() {
		return this.carriage;
	}

	public void setCarriage(double carriage) {
		this.carriage = carriage;
	}


	
	public String getCommercialVoucher() {
		return this.commercialVoucher;
	}

	public void setCommercialVoucher(String commercialVoucher) {
		this.commercialVoucher = commercialVoucher;
	}


	public String getCommodity() {
		return this.commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}


	
	public int getCommodityNumber() {
		return this.commodityNumber;
	}

	public void setCommodityNumber(int commodityNumber) {
		this.commodityNumber = commodityNumber;
	}


	
	
	public Date getDealTime() {
		return this.dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}


	
	public String getModeOfDistribution() {
		return this.modeOfDistribution;
	}

	public void setModeOfDistribution(String modeOfDistribution) {
		this.modeOfDistribution = modeOfDistribution;
	}


	
	public String getModeOfPayment() {
		return this.modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	
	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	
	public double getOrderMoney() {
		return this.orderMoney;
	}

	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	}


	
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	
	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}


	
	public int getShippingAddressId() {
		return this.shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

}