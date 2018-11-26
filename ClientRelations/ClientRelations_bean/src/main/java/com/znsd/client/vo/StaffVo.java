package com.znsd.client.vo;

import java.util.Date;

public class StaffVo {
	private int staffId;
	private String staffName;
	private String sex;
	private String departmentAbbreviation;
	private String roleName;
	private int state;
	private Date lastTime;
	private String operationPersonName;
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
	public String getDepartmentAbbreviation() {
		return departmentAbbreviation;
	}
	public void setDepartmentAbbreviation(String departmentAbbreviation) {
		this.departmentAbbreviation = departmentAbbreviation;
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
	@Override
	public String toString() {
		return "StaffVo [staffId=" + staffId + ", staffName=" + staffName + ", sex=" + sex + ", departmentAbbreviation="
				+ departmentAbbreviation + ", roleName=" + roleName + ", state=" + state + ", lastTime=" + lastTime
				+ ", operationPersonName=" + operationPersonName + "]";
	}
}
