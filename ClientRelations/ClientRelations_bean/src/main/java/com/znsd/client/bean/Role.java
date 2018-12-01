package com.znsd.client.bean;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the role database table.
 * 
 */

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	private int roleId;
	private int departmentId;
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", departmentId=" + departmentId + ", lastTime=" + lastTime
				+ ", operationPerson=" + operationPerson + ", remarksExplain=" + remarksExplain + ", roleName="
				+ roleName + "]";
	}

	private Date lastTime;
	private int operationPerson;
	private String remarksExplain;
	private String roleName;

	public Role() {
	}


	
	
	
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	
	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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


	
	public String getRemarksExplain() {
		return this.remarksExplain;
	}

	public void setRemarksExplain(String remarksExplain) {
		this.remarksExplain = remarksExplain;
	}


	
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}