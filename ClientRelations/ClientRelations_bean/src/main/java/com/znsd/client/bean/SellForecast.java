package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the sell_forecast database table.
 * 
 */


public class SellForecast implements Serializable {
	private static final long serialVersionUID = 1L;
	private int forecastId;
	private int branchId;
	private int clientNumber;
	private Date forecastMonth;
	private Date foundTime;
	private Date lastTime;
	private int operatorId;
	private int sectorScale;
	private String title;

	public SellForecast() {
	}


	
	
	
	public int getForecastId() {
		return this.forecastId;
	}

	public void setForecastId(int forecastId) {
		this.forecastId = forecastId;
	}


	
	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}


	
	public int getClientNumber() {
		return this.clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}


	
	
	public Date getForecastMonth() {
		return this.forecastMonth;
	}

	public void setForecastMonth(Date forecastMonth) {
		this.forecastMonth = forecastMonth;
	}


	
	
	public Date getFoundTime() {
		return this.foundTime;
	}

	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}


	
	
	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}


	
	public int getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}


	
	public int getSectorScale() {
		return this.sectorScale;
	}

	public void setSectorScale(int sectorScale) {
		this.sectorScale = sectorScale;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}