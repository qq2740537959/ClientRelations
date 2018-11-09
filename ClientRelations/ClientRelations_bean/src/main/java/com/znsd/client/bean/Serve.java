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
	private int createBy;
	private Date createTime;
	private int deleteFlag;
	private Date endTime;
	private int operator;
	private int pendingPeople;
	private String phone;
	private int serveClient;
	private String serveContent;
	private String serveName;
	private int serveState;
	private int serveType;
	private int updateBy;
	private Date updateTime;

	public Serve() {
	}


	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	
	public int getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}


	
	
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	
	public int getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	
	
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public int getOperator() {
		return this.operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}


	
	public int getPendingPeople() {
		return this.pendingPeople;
	}

	public void setPendingPeople(int pendingPeople) {
		this.pendingPeople = pendingPeople;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	
	public int getServeClient() {
		return this.serveClient;
	}

	public void setServeClient(int serveClient) {
		this.serveClient = serveClient;
	}


	
	public String getServeContent() {
		return this.serveContent;
	}

	public void setServeContent(String serveContent) {
		this.serveContent = serveContent;
	}


	
	public String getServeName() {
		return this.serveName;
	}

	public void setServeName(String serveName) {
		this.serveName = serveName;
	}


	
	public int getServeState() {
		return this.serveState;
	}

	public void setServeState(int serveState) {
		this.serveState = serveState;
	}


	
	public int getServeType() {
		return this.serveType;
	}

	public void setServeType(int serveType) {
		this.serveType = serveType;
	}


	
	public int getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}


	
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}