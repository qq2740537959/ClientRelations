package com.znsd.client.vo;

public class ClientVo {
	private Integer clientId;
	private String clientName;
	private String phone;
	private String sex;
	private String clientType;
	private Integer state;
	private Integer consumptionTimes;
	private double totalConsumptionAmount;
	private Integer staffId;
	private String staffName;
	public ClientVo(Integer clientId, String clientName,String phone, String sex, String clientType, Integer state,
			Integer consumptionTimes, double totalConsumptionAmount, Integer staffId, String staffName) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.phone = phone;
		this.sex = sex;
		this.clientType = clientType;
		this.state = state;
		this.consumptionTimes = consumptionTimes;
		this.totalConsumptionAmount = totalConsumptionAmount;
		this.staffId = staffId;
		this.staffName = staffName;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getConsumptionTimes() {
		return consumptionTimes;
	}
	public void setConsumptionTimes(Integer consumptionTimes) {
		this.consumptionTimes = consumptionTimes;
	}
	public double getTotalConsumptionAmount() {
		return totalConsumptionAmount;
	}
	public void setTotalConsumptionAmount(double totalConsumptionAmount) {
		this.totalConsumptionAmount = totalConsumptionAmount;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ClientVo [clientId=" + clientId + ", clientName=" + clientName + ", phone=" + phone + ", sex=" + sex
				+ ", clientType=" + clientType + ", state=" + state + ", consumptionTimes=" + consumptionTimes
				+ ", totalConsumptionAmount=" + totalConsumptionAmount + ", staffId=" + staffId + ", staffName="
				+ staffName + "]";
	}
}
