package com.znsd.client.vo;

import java.util.Date;

public class StaffLoginVo {
	private int staffId;
	public StaffLoginVo() {
		super();
	}
	private String staffName;
	private String sex;
	private int roleId;
	private String roleName;
	private int state;
	private String userName;
	private String remarksInfo;
	public String getRemarksInfo() {
		return remarksInfo;
	}
	public void setRemarksInfo(String remarksInfo) {
		this.remarksInfo = remarksInfo;
	}
	private String password;
	private String contactMode;
	private Date lastTime;
	private String operationPersonName;
	private String departmentAbbreviation;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactMode() {
		return contactMode;
	}
	public void setContactMode(String contactMode) {
		this.contactMode = contactMode;
	}
	@Override
	public String toString() {
		return "StaffLoginVo [staffId=" + staffId + ", staffName=" + staffName + ", sex=" + sex + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", state=" + state + ", userName=" + userName + ", password=" + password
				+ ", contactMode=" + contactMode + ", lastTime=" + lastTime + ", operationPersonName="
				+ operationPersonName + ", departmentAbbreviation=" + departmentAbbreviation + "]";
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public String getOperationPersonName() {
		return operationPersonName;
	}
	public void setOperationPersonName(String operationPersonName) {
		this.operationPersonName = operationPersonName;
	}
	public String getDepartmentAbbreviation() {
		return departmentAbbreviation;
	}
	public void setDepartmentAbbreviation(String departmentAbbreviation) {
		this.departmentAbbreviation = departmentAbbreviation;
	}
	
}