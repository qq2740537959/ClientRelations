package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the sell_plan database table.
 * 
 */

public class SellPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	private int planId;
	private Date lastTime;
	private int money;
	private int pendingId;
	private String planContent;
	private Date planMonth;
	private int sellingId;
	private int state;

	public SellPlan() {
	}


	
	
	
	public int getPlanId() {
		return this.planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}


	
	
	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}


	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


	
	public int getPendingId() {
		return this.pendingId;
	}

	public void setPendingId(int pendingId) {
		this.pendingId = pendingId;
	}


	
	public String getPlanContent() {
		return this.planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}


	
	
	public Date getPlanMonth() {
		return this.planMonth;
	}

	public void setPlanMonth(Date planMonth) {
		this.planMonth = planMonth;
	}


	
	public int getSellingId() {
		return this.sellingId;
	}

	public void setSellingId(int sellingId) {
		this.sellingId = sellingId;
	}


	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

}