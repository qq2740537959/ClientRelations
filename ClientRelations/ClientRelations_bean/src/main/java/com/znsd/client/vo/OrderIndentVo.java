package com.znsd.client.vo;

import java.sql.Timestamp;
import java.util.Date;

public class OrderIndentVo {
	private Integer id;//订单id
	private String orderType;//订单类型
	private String orderCode;//订单号
	private String commodity;//购买的商品
	private String consigneeName;//收货人姓名
	private double orderMoney;//订单交易金额
	private Timestamp dealTime;//交易时间
	private String orderStatus;//交易状态
	private String province;//省
	private String city;//市
	private String area;//区
	private String detailAddress;//详细地址
	
	public OrderIndentVo(Integer id, String orderType, String orderCode, String commodity, String consigneeName,
			double orderMoney, Timestamp dealTime, String orderStatus, String province, String city, String area,
			String detailAddress) {
		super();
		this.id = id;
		this.orderType = orderType;
		this.orderCode = orderCode;
		this.commodity = commodity;
		this.consigneeName = consigneeName;
		this.orderMoney = orderMoney;
		this.dealTime = dealTime;
		this.orderStatus = orderStatus;
		this.province = province;
		this.city = city;
		this.area = area;
		this.detailAddress = detailAddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public double getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(double orderMoney) {
		this.orderMoney = orderMoney;
	}
	public Timestamp getDealTime() {
		return dealTime;
	}
	public void setDealTime(Timestamp dealTime) {
		this.dealTime = dealTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	@Override
	public String toString() {
		return "OrderIndentVo [id=" + id + ", orderType=" + orderType + ", orderCode=" + orderCode + ", commodity="
				+ commodity + ", consigneeName=" + consigneeName + ", orderMoney=" + orderMoney + ", dealTime="
				+ dealTime + ", orderStatus=" + orderStatus + ", province=" + province + ", city=" + city + ", area="
				+ area + ", detailAddress=" + detailAddress + "]";
	}
}
