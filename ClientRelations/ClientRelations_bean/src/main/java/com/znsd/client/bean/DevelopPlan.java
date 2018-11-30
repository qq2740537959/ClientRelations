package com.znsd.client.bean;

public class DevelopPlan {

	private Integer planId; // 编码
	private String planName; // 计划人姓名
	private Integer clientId; // 客户id
	private Integer staffId; // （操作人）销售代表id
	private String planContent; // 计划内容
	private String foundTime; // 创建时间
	private String planMonth; // 计划月份
	private String lastOpterateTime; // 最后操作时间
	private String planStatus; // 计划状态

	public DevelopPlan() {
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public String getFoundTime() {
		return foundTime;
	}

	public void setFoundTime(String foundTime) {
		this.foundTime = foundTime;
	}

	public String getPlanMonth() {
		return planMonth;
	}

	public void setPlanMonth(String planMonth) {
		this.planMonth = planMonth;
	}

	public String getLastOpterateTime() {
		return lastOpterateTime;
	}

	public void setLastOpterateTime(String lastOpterateTime) {
		this.lastOpterateTime = lastOpterateTime;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	@Override
	public String toString() {
		return "DevelopPlan [planId=" + planId + ", planName=" + planName + ", clientId=" + clientId + ", staffId="
				+ staffId + ", planContent=" + planContent + ", foundTime=" + foundTime + ", planMothod=" + planMonth
				+ ", lastOpterateTime=" + lastOpterateTime + ", planStatus=" + planStatus + "]";
	}

}
