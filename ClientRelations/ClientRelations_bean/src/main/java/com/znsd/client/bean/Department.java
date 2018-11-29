package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the department database table.
 * 
 */


public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	private int departmentId;
	private String departmentAbbreviation;
	private String departmentFullname;
	private String departmentOutline;
	private Date lastTime;
	private int operationPerson;
	private int parentId;
	private String remarksInfo;

	public Department() {
	}


	
	
	
	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	
	public String getDepartmentAbbreviation() {
		return this.departmentAbbreviation;
	}

	public void setDepartmentAbbreviation(String departmentAbbreviation) {
		this.departmentAbbreviation = departmentAbbreviation;
	}


	
	public String getDepartmentFullname() {
		return this.departmentFullname;
	}

	public void setDepartmentFullname(String departmentFullname) {
		this.departmentFullname = departmentFullname;
	}


	
	public String getDepartmentOutline() {
		return this.departmentOutline;
	}

	public void setDepartmentOutline(String departmentOutline) {
		this.departmentOutline = departmentOutline;
	}


	
	
	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}


	
	public int getOperationPerson() {
		return this.operationPerson;
	}

	public void setOperationPerson(int operationPerson) {
		this.operationPerson = operationPerson;
	}


	
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	
	public String getRemarksInfo() {
		return this.remarksInfo;
	}

	public void setRemarksInfo(String remarksInfo) {
		this.remarksInfo = remarksInfo;
	}

}