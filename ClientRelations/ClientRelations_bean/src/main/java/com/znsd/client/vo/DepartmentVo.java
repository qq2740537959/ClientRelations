package com.znsd.client.vo;

import java.util.Date;

public class DepartmentVo {
	private int departmentId;
	private String departmentAbbreviation;
	private String departmentFullname;
	private String departmentOutline;
	private Date lastTime;
	private int operationPerson;
	private int parentId;
	private String remarksInfo;
	private String operationPersonName;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentAbbreviation() {
		return departmentAbbreviation;
	}
	public void setDepartmentAbbreviation(String departmentAbbreviation) {
		this.departmentAbbreviation = departmentAbbreviation;
	}
	public String getDepartmentFullname() {
		return departmentFullname;
	}
	public void setDepartmentFullname(String departmentFullname) {
		this.departmentFullname = departmentFullname;
	}
	public String getDepartmentOutline() {
		return departmentOutline;
	}
	public void setDepartmentOutline(String departmentOutline) {
		this.departmentOutline = departmentOutline;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getRemarksInfo() {
		return remarksInfo;
	}
	public void setRemarksInfo(String remarksInfo) {
		this.remarksInfo = remarksInfo;
	}
	public String getOperationPersonName() {
		return operationPersonName;
	}
	public void setOperationPersonName(String operationPersonName) {
		this.operationPersonName = operationPersonName;
	}
	@Override
	public String toString() {
		return "DepartmentVo [departmentId=" + departmentId + ", departmentAbbreviation=" + departmentAbbreviation
				+ ", departmentFullname=" + departmentFullname + ", departmentOutline=" + departmentOutline
				+ ", lastTime=" + lastTime + ", operationPerson=" + operationPerson + ", parentId=" + parentId
				+ ", remarksInfo=" + remarksInfo + ", operationPersonName=" + operationPersonName + "]";
	}
	public DepartmentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
