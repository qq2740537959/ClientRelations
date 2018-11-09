package com.znsd.client.bean;

import java.io.Serializable;


/**
 * The persistent class for the user_role database table.
 * 
 */


public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int roleId;
	private int staffId;

	public UserRole() {
	}


	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	
	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

}