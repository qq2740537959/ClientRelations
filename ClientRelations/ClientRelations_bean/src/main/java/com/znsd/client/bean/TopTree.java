package com.znsd.client.bean;

public class TopTree {
	private Integer id;
	private Integer pId;
	private String name;
	private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TopTree [id=" + id + ", pId=" + pId + ", name=" + name + ", type=" + type + "]";
	}
}
