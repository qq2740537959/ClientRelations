package com.znsd.client.bean;

public class School {
	private Integer tId;
	private String tName;
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	@Override
	public String toString() {
		return "School [tId=" + tId + ", tName=" + tName + "]";
	}
}
