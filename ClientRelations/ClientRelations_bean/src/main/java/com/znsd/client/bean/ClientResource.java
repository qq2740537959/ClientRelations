package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the client_resource database table.
 * 
 */


public class ClientResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private int clientId;
	private int allotState;
	private String clientName;
	private int clientType;
	private String contactAddress;
	private String email;
	private int entryPerson;
	private String familyPhone;
	private Date inTime;
	private String phone;
	private String remark;
	private int roleId;
	private String sex;
	private int staffId;
	private int state;
	private String workPhone;

	public ClientResource() {
	}


	
	
	
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	
	public int getAllotState() {
		return this.allotState;
	}

	public void setAllotState(int allotState) {
		this.allotState = allotState;
	}


	
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	
	public int getClientType() {
		return this.clientType;
	}

	public void setClientType(int clientType) {
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


	
	
	public Date getInTime() {
		return this.inTime;
	}

	public void setInTime(Date inTime) {
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

}