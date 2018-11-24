package com.znsd.client.vo;

import java.sql.Timestamp;

public class OrderStatisticsVo {
	private String months;//月份
	private int totalOrderNumber;//订单总数量
	private double totalOrderMoney;//订单总金额
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	public int getTotalOrderNumber() {
		return totalOrderNumber;
	}
	public void setTotalOrderNumber(int totalOrderNumber) {
		this.totalOrderNumber = totalOrderNumber;
	}
	public double getTotalOrderMoney() {
		return totalOrderMoney;
	}
	public void setTotalOrderMoney(double totalOrderMoney) {
		this.totalOrderMoney = totalOrderMoney;
	}
	@Override
	public String toString() {
		return "OrderStatisticsVo [months=" + months + ", totalOrderNumber=" + totalOrderNumber + ", totalOrderMoney=" + totalOrderMoney
				+ "]";
	}
	
}
