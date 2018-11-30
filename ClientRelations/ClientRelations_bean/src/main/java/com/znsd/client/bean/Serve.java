package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the serve database table.
 * 
 */

public class Serve implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String comment;
	private String createBy;
	private Date createTime;
	private int deleteFlag;
	private Date endTime;
	private String operator;
	private String pendingPeople;
	private String phone;
	private String serveClient;
	private String serveContent;
	private String serveName;
	private String serveState;
	private String serveType;
	private String updateBy;
	private Date updateTime;

	public Serve() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getPendingPeople() {
		return pendingPeople;
	}

	public void setPendingPeople(String pendingPeople) {
		this.pendingPeople = pendingPeople;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getServeClient() {
		return serveClient;
	}

	public void setServeClient(String serveClient) {
		this.serveClient = serveClient;
	}

	public String getServeContent() {
		return serveContent;
	}

	public void setServeContent(String serveContent) {
		this.serveContent = serveContent;
	}

	public String getServeName() {
		return serveName;
	}

	public void setServeName(String serveName) {
		this.serveName = serveName;
	}

	public String getServeState() {
		return serveState;
	}

	public void setServeState(String serveState) {
		this.serveState = serveState;
	}

	public String getServeType() {
		return serveType;
	}

	public void setServeType(String serveType) {
		this.serveType = serveType;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Serve [id=" + id + ", comment=" + comment + ", createBy=" + createBy + ", createTime=" + createTime
				+ ", deleteFlag=" + deleteFlag + ", endTime=" + endTime + ", operator=" + operator + ", pendingPeople="
				+ pendingPeople + ", phone=" + phone + ", serveClient=" + serveClient + ", serveContent=" + serveContent
				+ ", serveName=" + serveName + ", serveState=" + serveState + ", serveType=" + serveType + ", updateBy="
				+ updateBy + ", updateTime=" + updateTime + "]";
	}
	

}