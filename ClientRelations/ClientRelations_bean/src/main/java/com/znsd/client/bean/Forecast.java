package com.znsd.client.bean;

public class Forecast {
	private int forecastId;
	private String title;
	private Integer branchId;
	private String lastTime;
	private String forecastMonth;
	private Integer operatorId;
	private Integer sectorScale;
	private Integer clientNumber;
	private String forecastContent;
	private String branchName;
	private String typeName;
	
	public int getForecastId() {
		return forecastId;
	}
	public void setForecastId(int forecastId) {
		this.forecastId = forecastId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public String getForecastMonth() {
		return forecastMonth;
	}
	public void setForecastMonth(String forecastMonth) {
		this.forecastMonth = forecastMonth;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public Integer getSectorScale() {
		return sectorScale;
	}
	public void setSectorScale(Integer sectorScale) {
		this.sectorScale = sectorScale;
	}
	public Integer getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getForecastContent() {
		return forecastContent;
	}
	public void setForecastContent(String forecastContent) {
		this.forecastContent = forecastContent;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	@Override
	public String toString() {
		return "Forecast [forecastId=" + forecastId + ", title=" + title + ", branchId=" + branchId + ", lastTime="
				+ lastTime + ", forecastMonth=" + forecastMonth + ", operatorId=" + operatorId + ", sectorScale="
				+ sectorScale + ", clientNumber=" + clientNumber + ", forecastContent=" + forecastContent
				+ ", branchName=" + branchName + ", typeName=" + typeName + "]";
	}
	public Forecast() {
		super();
	}
	
	
	
}
