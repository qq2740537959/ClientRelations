package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the issue database table.
 * 
 */

public class Issue implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String answer;
	private String comment;
	private int createBy;
	private Date createTime;
	private int deleteFlag;
	private Date endTime;
	private int issueType;
	private String title;
	private int updateBy;
	private Date updateTime;

	public Issue() {
	}


	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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


	
	public int getIssueType() {
		return this.issueType;
	}

	public void setIssueType(int issueType) {
		this.issueType = issueType;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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