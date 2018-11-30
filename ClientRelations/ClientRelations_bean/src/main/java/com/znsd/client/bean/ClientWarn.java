package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the client_warn database table.
 * 
 */


public class ClientWarn implements Serializable {
	private static final long serialVersionUID = 1L;
	private int remindId;
	private int clientId;
	private int clientValueGrade;
	private String remarksInfo;
	private int remindCycle;
	private int remindFrequency;
	private String remindName;
	private Date remindTime;
	private int remindType;

	public ClientWarn() {
	}


	
	
	
	public int getRemindId() {
		return this.remindId;
	}

	public void setRemindId(int remindId) {
		this.remindId = remindId;
	}


	
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	
	public int getClientValueGrade() {
		return this.clientValueGrade;
	}

	public void setClientValueGrade(int clientValueGrade) {
		this.clientValueGrade = clientValueGrade;
	}


	
	public String getRemarksInfo() {
		return this.remarksInfo;
	}

	public void setRemarksInfo(String remarksInfo) {
		this.remarksInfo = remarksInfo;
	}


	
	public int getRemindCycle() {
		return this.remindCycle;
	}

	public void setRemindCycle(int remindCycle) {
		this.remindCycle = remindCycle;
	}


	
	public int getRemindFrequency() {
		return this.remindFrequency;
	}

	public void setRemindFrequency(int remindFrequency) {
		this.remindFrequency = remindFrequency;
	}


	
	public String getRemindName() {
		return this.remindName;
	}

	public void setRemindName(String remindName) {
		this.remindName = remindName;
	}


	
	
	public Date getRemindTime() {
		return this.remindTime;
	}

	public void setRemindTime(Date remindTime) {
		this.remindTime = remindTime;
	}


	
	public int getRemindType() {
		return this.remindType;
	}

	public void setRemindType(int remindType) {
		this.remindType = remindType;
	}

}