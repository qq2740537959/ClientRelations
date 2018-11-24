package com.znsd.client.bean;

import java.io.Serializable;
import java.util.Date;




public class Hap implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer chanceId;//机会id
	private String chanceContent;//机会内容
	private String chanceName;//机会名称
	private Date entryTime;//创建时间
	private Integer handleId;//最后操作人
	private Date lastTime;//最后修改时间
	private Integer typeId;//类型id
	private Integer staffId;// 分配给谁
	private String remark;//备注
	private String entryId;//录入人
	private Integer client_id; //客户编码
	public Integer getChanceId() {
		return chanceId;
	}
	public void setChanceId(Integer chanceId) {
		this.chanceId = chanceId;
	}
	public String getChanceContent() {
		return chanceContent;
	}
	public void setChanceContent(String chanceContent) {
		this.chanceContent = chanceContent;
	}
	public String getChanceName() {
		return chanceName;
	}
	public void setChanceName(String chanceName) {
		this.chanceName = chanceName;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Integer getHandleId() {
		return handleId;
	}
	public void setHandleId(Integer handleId) {
		this.handleId = handleId;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEntryId() {
		return entryId;
	}
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}
	public Integer getClient_id() {
		return client_id;
	}
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	public Hap(Integer chanceId, String chanceContent, String chanceName, Date entryTime, Integer handleId,
			Date lastTime, Integer typeId, Integer staffId, String remark, String entryId, Integer client_id) {
		super();
		this.chanceId = chanceId;
		this.chanceContent = chanceContent;
		this.chanceName = chanceName;
		this.entryTime = entryTime;
		this.handleId = handleId;
		this.lastTime = lastTime;
		this.typeId = typeId;
		this.staffId = staffId;
		this.remark = remark;
		this.entryId = entryId;
		this.client_id = client_id;
	}
	public Hap() {
		super();
	}
	@Override
	public String toString() {
		return "Hap [chanceId=" + chanceId + ", chanceContent=" + chanceContent + ", chanceName=" + chanceName
				+ ", entryTime=" + entryTime + ", handleId=" + handleId + ", lastTime=" + lastTime + ", typeId="
				+ typeId + ", staffId=" + staffId + ", remark=" + remark + ", entryId=" + entryId + ", client_id="
				+ client_id + "]";
	}
	
	
	
	
	

}