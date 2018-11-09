package com.znsd.client.bean;

import java.io.Serializable;


/**
 * The persistent class for the client_survey database table.
 * 
 */


public class ClientSurvey implements Serializable {
	private static final long serialVersionUID = 1L;
	private String benefitPleased;
	private int clientId;
	private String creditGrade;
	private String feedback;
	private int greetId;
	private String qualityPleased;
	private String servePleased;
	private String totalPleased;

	public ClientSurvey() {
	}


	
	public String getBenefitPleased() {
		return this.benefitPleased;
	}

	public void setBenefitPleased(String benefitPleased) {
		this.benefitPleased = benefitPleased;
	}


	
	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	
	public String getCreditGrade() {
		return this.creditGrade;
	}

	public void setCreditGrade(String creditGrade) {
		this.creditGrade = creditGrade;
	}


	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	
	public int getGreetId() {
		return this.greetId;
	}

	public void setGreetId(int greetId) {
		this.greetId = greetId;
	}


	
	public String getQualityPleased() {
		return this.qualityPleased;
	}

	public void setQualityPleased(String qualityPleased) {
		this.qualityPleased = qualityPleased;
	}


	
	public String getServePleased() {
		return this.servePleased;
	}

	public void setServePleased(String servePleased) {
		this.servePleased = servePleased;
	}


	
	public String getTotalPleased() {
		return this.totalPleased;
	}

	public void setTotalPleased(String totalPleased) {
		this.totalPleased = totalPleased;
	}

}