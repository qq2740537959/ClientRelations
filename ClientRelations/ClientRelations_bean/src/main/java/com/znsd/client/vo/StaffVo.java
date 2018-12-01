package com.znsd.client.vo;

import java.util.Date;

public class StaffVo {
	private int staffId;
	private String staffName;
	private String sex;
	private String departmentAbbreviation;
	private String roleName;
	private String remarksInfo;
	private int state;
	private Date createTime;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	private Date lastTime;
	private String operationPersonName;

	public int getStaffId() {
		return staffId;
	}
	@Override
	public String toString() {
		return "StaffVo [staffId=" + staffId + ", staffName=" + staffName + ", sex=" + sex + ", departmentAbbreviation="
				+ departmentAbbreviation + ", roleName=" + roleName + ", remarksInfo=" + remarksInfo + ", state="
				+ state + ", createTime=" + createTime + ", lastTime=" + lastTime + ", operationPersonName="
				+ operationPersonName + "]";
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
	public String getRemarksInfo() {
		return remarksInfo;
	}
	public void setRemarksInfo(String remarksInfo) {
		this.remarksInfo = remarksInfo;
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
	public StaffVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
