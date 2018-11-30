package com.znsd.client.vo;

import java.util.Date;

public class NoticeVo {
	private int noticeId;
	private String noticeTitle;
	private int noticeType;
	private String releaseContent;
	private Date releaseTime;
	private String releasePersonName;
	@Override
	public String toString() {
		return "NoticeVo [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeType=" + noticeType
				+ ", releaseContent=" + releaseContent + ", releaseTime=" + releaseTime + ", releasePersonName="
				+ releasePersonName + "]";
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public int getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(int noticeType) {
		this.noticeType = noticeType;
	}
	public String getReleaseContent() {
		return releaseContent;
	}
	public void setReleaseContent(String releaseContent) {
		this.releaseContent = releaseContent;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getReleasePersonName() {
		return releasePersonName;
	}
	public void setReleasePersonName(String releasePersonName) {
		this.releasePersonName = releasePersonName;
	}
	public NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
