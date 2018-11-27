package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the contract database table.
 * 
 */

public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;
	private int contractId;
	private String anotherLicence;
	private String contractContent;
	private double contractMoney;
	private String contractName;
	private int contractState;
	private int contractType;
	private String examine;
	private int staffId;
	private String lastTime;
	private String myselfLicence;
	private String otherCompany;
	private String ownCompany;
	private String performance;
	private String reasonsChange;
	private String relieve;
	private String remarks;
	private String transferPossession;

	public Contract() {
	}


	
	
	
	public int getContractId() {
		return this.contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}


	
	public String getAnotherLicence() {
		return this.anotherLicence;
	}

	public void setAnotherLicence(String anotherLicence) {
		this.anotherLicence = anotherLicence;
	}


	
	public String getContractContent() {
		return this.contractContent;
	}

	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
	}


	
	public double getContractMoney() {
		return this.contractMoney;
	}

	public void setContractMoney(double contractMoney) {
		this.contractMoney = contractMoney;
	}


	
	public String getContractName() {
		return this.contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}


	
	public int getContractState() {
		return this.contractState;
	}

	public void setContractState(int contractState) {
		this.contractState = contractState;
	}


	
	public int getContractType() {
		return this.contractType;
	}

	public void setContractType(int contractType) {
		this.contractType = contractType;
	}


	public String getExamine() {
		return this.examine;
	}

	public void setExamine(String examine) {
		this.examine = examine;
	}


	
	

	
	



	
	public int getStaffId() {
		return staffId;
	}





	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}





	public String getLastTime() {
		return lastTime;
	}





	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}





	public String getMyselfLicence() {
		return this.myselfLicence;
	}

	public void setMyselfLicence(String myselfLicence) {
		this.myselfLicence = myselfLicence;
	}


	
	public String getOtherCompany() {
		return this.otherCompany;
	}

	public void setOtherCompany(String otherCompany) {
		this.otherCompany = otherCompany;
	}


	
	public String getOwnCompany() {
		return this.ownCompany;
	}

	public void setOwnCompany(String ownCompany) {
		this.ownCompany = ownCompany;
	}


	public String getPerformance() {
		return this.performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}


	
	public String getReasonsChange() {
		return this.reasonsChange;
	}

	public void setReasonsChange(String reasonsChange) {
		this.reasonsChange = reasonsChange;
	}


	public String getRelieve() {
		return this.relieve;
	}

	public void setRelieve(String relieve) {
		this.relieve = relieve;
	}


	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	
	public String getTransferPossession() {
		return this.transferPossession;
	}

	public void setTransferPossession(String transferPossession) {
		this.transferPossession = transferPossession;
	}


	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", anotherLicence=" + anotherLicence + ", contractContent="
				+ contractContent + ", contractMoney=" + contractMoney + ", contractName=" + contractName
				+ ", contractState=" + contractState + ", contractType=" + contractType + ", examine=" + examine
				+ ", staffId=" + staffId + ", lastTime=" + lastTime + ", myselfLicence=" + myselfLicence
				+ ", otherCompany=" + otherCompany + ", ownCompany=" + ownCompany + ", performance=" + performance
				+ ", reasonsChange=" + reasonsChange + ", relieve=" + relieve + ", remarks=" + remarks
				+ ", transferPossession=" + transferPossession + "]";
	}





	public Contract(int contractId, String anotherLicence, String contractContent, double contractMoney,
			String contractName, int contractState, int contractType, String examine, int staffId, String lastTime,
			String myselfLicence, String otherCompany, String ownCompany, String performance, String reasonsChange,
			String relieve, String remarks, String transferPossession) {
		super();
		this.contractId = contractId;
		this.anotherLicence = anotherLicence;
		this.contractContent = contractContent;
		this.contractMoney = contractMoney;
		this.contractName = contractName;
		this.contractState = contractState;
		this.contractType = contractType;
		this.examine = examine;
		this.staffId = staffId;
		this.lastTime = lastTime;
		this.myselfLicence = myselfLicence;
		this.otherCompany = otherCompany;
		this.ownCompany = ownCompany;
		this.performance = performance;
		this.reasonsChange = reasonsChange;
		this.relieve = relieve;
		this.remarks = remarks;
		this.transferPossession = transferPossession;
	}

	
}