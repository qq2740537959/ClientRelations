package com.znsd.client.vo;

import java.sql.Timestamp;

public class ContractVo {
	private Integer contractId;
	private String contractName;
	private String genreName;
	private String shapeName;
	private String lastTime;
	private String staffName;
	public Integer getContractId() {
		return contractId;
	}
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public String getShapeName() {
		return shapeName;
	}
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}
	
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	@Override
	public String toString() {
		return "ContractVo [contractId=" + contractId + ", contractName=" + contractName + ", genreName=" + genreName
				+ ", shapeName=" + shapeName + ", lastTime=" + lastTime + ", staffName=" + staffName + "]";
	}
	public ContractVo(Integer contractId, String contractName, String genreName, String shapeName, String lastTime,
			String staffName) {
		super();
		this.contractId = contractId;
		this.contractName = contractName;
		this.genreName = genreName;
		this.shapeName = shapeName;
		this.lastTime = lastTime;
		this.staffName = staffName;
	}
	
	
}
