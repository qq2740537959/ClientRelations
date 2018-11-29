package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the statistics database table.
 * 
 */


public class Statistic implements Serializable {
	private static final long serialVersionUID = 1L;
	private int statisticsId;
	private int statisticsContribution;
	private int statisticsCustomerNumber;
	private Date statisticsDate;
	private int statisticsLossQuantity;
	private double statisticsRingRatio;
	private double statisticsSameTimeRatio;
	private int statisticsServiceQuantity;

	public Statistic() {
	}


	
	
	
	public int getStatisticsId() {
		return this.statisticsId;
	}

	public void setStatisticsId(int statisticsId) {
		this.statisticsId = statisticsId;
	}


	
	public int getStatisticsContribution() {
		return this.statisticsContribution;
	}

	public void setStatisticsContribution(int statisticsContribution) {
		this.statisticsContribution = statisticsContribution;
	}


	
	public int getStatisticsCustomerNumber() {
		return this.statisticsCustomerNumber;
	}

	public void setStatisticsCustomerNumber(int statisticsCustomerNumber) {
		this.statisticsCustomerNumber = statisticsCustomerNumber;
	}


	
	
	public Date getStatisticsDate() {
		return this.statisticsDate;
	}

	public void setStatisticsDate(Date statisticsDate) {
		this.statisticsDate = statisticsDate;
	}


	
	public int getStatisticsLossQuantity() {
		return this.statisticsLossQuantity;
	}

	public void setStatisticsLossQuantity(int statisticsLossQuantity) {
		this.statisticsLossQuantity = statisticsLossQuantity;
	}


	
	public double getStatisticsRingRatio() {
		return this.statisticsRingRatio;
	}

	public void setStatisticsRingRatio(double statisticsRingRatio) {
		this.statisticsRingRatio = statisticsRingRatio;
	}


	
	public double getStatisticsSameTimeRatio() {
		return this.statisticsSameTimeRatio;
	}

	public void setStatisticsSameTimeRatio(double statisticsSameTimeRatio) {
		this.statisticsSameTimeRatio = statisticsSameTimeRatio;
	}


	
	public int getStatisticsServiceQuantity() {
		return this.statisticsServiceQuantity;
	}

	public void setStatisticsServiceQuantity(int statisticsServiceQuantity) {
		this.statisticsServiceQuantity = statisticsServiceQuantity;
	}

}