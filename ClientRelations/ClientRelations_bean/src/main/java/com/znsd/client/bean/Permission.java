package com.znsd.client.bean;

import java.io.Serializable;


/**
 * The persistent class for the permission database table.
 * 
 */

public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int parentId;
	private String permission;
	private int type;

	public Permission() {
	}


	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}