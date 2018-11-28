package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * The persistent class for the client_resource database table.
 * 
 */


public class ClientResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer clientId;
	private int allotState;
	private String clientName;
	private String clientType;
	private String contactAddress;
	private String email;
	private int entryPerson;
	private String birthday;
	private String familyPhone;
	private String inTime;
	private String phone;
	private String remark;
	private int chanceId;
	private int roleId;
	private String sex;
	private int staffId;
	private int state;
	private String workPhone;
	private int consumptionTimes;
	private double totalConsumptionAmount;

	public ClientResource() {
	}

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	
	public int getAllotState() {
		return this.allotState;
	}

	public void setAllotState(int allotState) {
		this.allotState = allotState;
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getChanceId() {
		return chanceId;
	}

	public void setChanceId(int chanceId) {
		this.chanceId = chanceId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	
	public String getClientType() {
		return this.clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}


	
	public String getContactAddress() {
		return this.contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	public int getEntryPerson() {
		return this.entryPerson;
	}

	public void setEntryPerson(int entryPerson) {
		this.entryPerson = entryPerson;
	}


	
	public String getFamilyPhone() {
		return this.familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}


	
	
	public String getInTime() {
		return this.inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	
	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}


	
	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public int getConsumptionTimes() {
		return consumptionTimes;
	}

	public void setConsumptionTimes(int consumptionTimes) {
		this.consumptionTimes = consumptionTimes;
	}

	public double getTotalConsumptionAmount() {
		return totalConsumptionAmount;
	}

	public void setTotalConsumptionAmount(double totalConsumptionAmount) {
		this.totalConsumptionAmount = totalConsumptionAmount;
	}

	@Override
	public String toString() {
		return "ClientResource [clientId=" + clientId + ", allotState=" + allotState + ", clientName=" + clientName
				+ ", clientType=" + clientType + ", contactAddress=" + contactAddress + ", email=" + email
				+ ", entryPerson=" + entryPerson + ", birthday=" + birthday + ", familyPhone=" + familyPhone
				+ ", inTime=" + inTime + ", phone=" + phone + ", remark=" + remark + ", chanceId=" + chanceId
				+ ", roleId=" + roleId + ", sex=" + sex + ", staffId=" + staffId + ", state=" + state + ", workPhone="
				+ workPhone + ", consumptionTimes=" + consumptionTimes + ", totalConsumptionAmount="
				+ totalConsumptionAmount + "]";
	}

}