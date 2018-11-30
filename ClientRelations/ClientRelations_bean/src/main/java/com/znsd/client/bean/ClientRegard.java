package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the client_regard database table.
 * 
 */


public class ClientRegard implements Serializable {
	private static final long serialVersionUID = 1L;
	private int greetId;
	private int clientId;
	private String greetName;
	private String implementProgramme;
	private Date implementTime;
	private int programmeState;
	private String remarksInfo;

	public ClientRegard() {
	}


	
	
	
	public int getGreetId() {
		return this.greetId;
	}

	public void setGreetId(int greetId) {
		this.greetId = greetId;
	}


	
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	
	public String getGreetName() {
		return this.greetName;
	}

	public void setGreetName(String greetName) {
		this.greetName = greetName;
	}


	
	public String getImplementProgramme() {
		return this.implementProgramme;
	}

	public void setImplementProgramme(String implementProgramme) {
		this.implementProgramme = implementProgramme;
	}


	
	
	public Date getImplementTime() {
		return this.implementTime;
	}

	public void setImplementTime(Date implementTime) {
		this.implementTime = implementTime;
	}


	
	public int getProgrammeState() {
		return this.programmeState;
	}

	public void setProgrammeState(int programmeState) {
		this.programmeState = programmeState;
	}


	
	public String getRemarksInfo() {
		return this.remarksInfo;
	}

	public void setRemarksInfo(String remarksInfo) {
		this.remarksInfo = remarksInfo;
	}

}