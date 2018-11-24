package com.znsd.client.bean;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int clientId;
	private String consigneeName;
	private String phone;
	private String province;
	private String city;
	private String area;
	private String detailAddress;
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
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
		return "Address [id=" + id + ", clientId=" + clientId + ", consigneeName=" + consigneeName + ", phone=" + phone
				+ ", province=" + province + ", city=" + city + ", area=" + area + ", detailAddress=" + detailAddress
				+ "]";
	}
}