package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the staff database table.
 * 
 */

public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;
	private int staffId;
	private String contactMode;
	private int departmentId;
	private Date createTime;
	private Date lastTime;
	private int operationPerson;
	private String password;
	private String remarksInfo;
	private int roleIdentity;
	private String sex;
	private String staffName;
	private int state;
	private String userName;

	public Staff() {
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getContactMode() {
		return contactMode;
	}

	public void setContactMode(String contactMode) {
		this.contactMode = contactMode;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public int getOperationPerson() {
		return operationPerson;
	}

	public void setOperationPerson(int operationPerson) {
		this.operationPerson = operationPerson;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemarksInfo() {
		return remarksInfo;
	}

	public void setRemarksInfo(String remarksInfo) {
		this.remarksInfo = remarksInfo;
	}

	public int getRoleIdentity() {
		return roleIdentity;
	}

	public void setRoleIdentity(int roleIdentity) {
		this.roleIdentity = roleIdentity;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", contactMode=" + contactMode + ", departmentId=" + departmentId
				+ ", createTime=" + createTime + ", lastTime=" + lastTime + ", operationPerson=" + operationPerson
				+ ", password=" + password + ", remarksInfo=" + remarksInfo + ", roleIdentity=" + roleIdentity
				+ ", sex=" + sex + ", staffName=" + staffName + ", state=" + state + ", userName=" + userName + "]";
	}


}