package com.znsd.client.vo;

import java.util.Date;

public class RoleQueryVo {
	private int roleId;
	private String roleName;
	private String departmentAbbreviation;
	private Date lastTime;
	private String staffName;
	private String remarksExplain;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDepartmentAbbreviation() {
		return departmentAbbreviation;
	}
	public void setDepartmentAbbreviation(String departmentAbbreviation) {
		this.departmentAbbreviation = departmentAbbreviation;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getRemarksExplain() {
		return remarksExplain;
	}
	public void setRemarksExplain(String remarksExplain) {
		this.remarksExplain = remarksExplain;
	}
	@Override
	public String toString() {
		return "RoleQueryVo [roleId=" + roleId + ", roleName=" + roleName + ", departmentAbbreviation="
				+ departmentAbbreviation + ", lastTime=" + lastTime + ", staffName=" + staffName + ", remarksExplain="
				+ remarksExplain + "]";
	}
	public RoleQueryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
