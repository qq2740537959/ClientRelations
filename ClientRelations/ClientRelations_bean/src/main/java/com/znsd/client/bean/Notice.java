package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the notice database table.
 * 
 */

public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;
	private int noticeId;
	private String noticeTitle;
	private int noticeType;
	private String releaseContent;
	private Date releaseTime;
	private int releasePerson;

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeType=" + noticeType
				+ ", releaseContent=" + releaseContent + ", releaseTime=" + releaseTime + ", releasePerson="
				+ releasePerson + "]";
	}





	public Date getReleaseTime() {
		return releaseTime;
	}





	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}





	public Notice() {
	}


	
	
	
	public int getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}


	
	public String getNoticeTitle() {
		return this.noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	
	public int getNoticeType() {
		return this.noticeType;
	}

	public void setNoticeType(int noticeType) {
		this.noticeType = noticeType;
	}


	
	public String getReleaseContent() {
		return this.releaseContent;
	}

	public void setReleaseContent(String releaseContent) {
		this.releaseContent = releaseContent;
	}


	
	public int getReleasePerson() {
		return this.releasePerson;
	}

	public void setReleasePerson(int releasePerson) {
		this.releasePerson = releasePerson;
	}

}