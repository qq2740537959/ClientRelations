package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the sell_performance database table.
 * 
 */


public class SellPerformance implements Serializable {
	private static final long serialVersionUID = 1L;
	private int scoreId;
	private int branchId;
	private int handleId;
	private Date lastTime;
	private String remark;
	private int scoreGrade;
	private int staffId;

	public SellPerformance() {
	}


	
	
	
	public int getScoreId() {
		return this.scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}


	
	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
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


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	
	public int getScoreGrade() {
		return this.scoreGrade;
	}

	public void setScoreGrade(int scoreGrade) {
		this.scoreGrade = scoreGrade;
	}


	
	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

}