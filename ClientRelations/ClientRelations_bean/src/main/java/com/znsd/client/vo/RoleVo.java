package com.znsd.client.vo;

public class RoleVo {
	private int staffId;
	private String staffName;
	private String roleName;
	private int roleId;
	private int roleIdentity;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getRoleIdentity() {
		return roleIdentity;
	}
	public void setRoleIdentity(int roleIdentity) {
		this.roleIdentity = roleIdentity;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public RoleVo(int staffId, String staffName, String roleName, int roleId, int roleIdentity) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.roleName = roleName;
		this.roleId = roleId;
		this.roleIdentity = roleIdentity;
	}
	@Override
	public String toString() {
		return "RoleVo [staffId=" + staffId + ", staffName=" + staffName + ", roleName=" + roleName + ", roleId="
				+ roleId + ", roleIdentity=" + roleIdentity + "]";
	}
	
}