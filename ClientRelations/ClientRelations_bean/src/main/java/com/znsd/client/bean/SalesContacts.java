package com.znsd.client.bean;

public class SalesContacts {
	private int contactsId;
	private String name;
	private String sex;
	private String phone;
	private String address;
	private String remark;
	private String birthday;
	private String chanceContent;
	private String workPhone;
	private String familyPhone;
	private String email;
	public int getContactsId() {
		return contactsId;
	}
	public void setContactsId(int contactsId) {
		this.contactsId = contactsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getChanceContent() {
		return chanceContent;
	}
	public void setChanceContent(String chanceContent) {
		this.chanceContent = chanceContent;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getFamilyPhone() {
		return familyPhone;
	}
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SalesContacts [contactsId=" + contactsId + ", name=" + name + ", sex=" + sex + ", phone=" + phone
				+ ", address=" + address + ", remark=" + remark + ", birthday=" + birthday + ", chanceContent="
				+ chanceContent + ", workPhone=" + workPhone + ", familyPhone=" + familyPhone + ", email=" + email
				+ "]";
	}
	public SalesContacts(int contactsId, String name, String sex, String phone, String address, String remark,
			String birthday, String chanceContent, String workPhone, String familyPhone, String email) {
		super();
		this.contactsId = contactsId;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.remark = remark;
		this.birthday = birthday;
		this.chanceContent = chanceContent;
		this.workPhone = workPhone;
		this.familyPhone = familyPhone;
		this.email = email;
	}
	public SalesContacts() {
		super();
	}

	
}
