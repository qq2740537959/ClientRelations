package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the hap database table.
 * 
 */

public class Hap implements Serializable {
	private static final long serialVersionUID = 1L;
	private int chanceId;
	private String chanceContent;
	private String chanceName;
	private Date entryTime;
	private int handleId;
	private Date lastTime;
	private int typeId;
	private int userId;

	public Hap() {
	}


	
	
	
	public int getChanceId() {
		return this.chanceId;
	}

	public void setChanceId(int chanceId) {
		this.chanceId = chanceId;
	}


	
	public String getChanceContent() {
		return this.chanceContent;
	}

	public void setChanceContent(String chanceContent) {
		this.chanceContent = chanceContent;
	}


	
	public String getChanceName() {
		return this.chanceName;
	}

	public void setChanceName(String chanceName) {
		this.chanceName = chanceName;
	}


	
	
	public Date getEntryTime() {
		return this.entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}


	
	public int getHandleId() {
		return this.handleId;
	}

	public void setHandleId(int handleId) {
		this.handleId = handleId;
	}


	
	
	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}


	
	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}