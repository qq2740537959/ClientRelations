package com.znsd.client.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.znsd.client.bean.SalesContacts;
import com.znsd.client.service.ContactsService;

@SuppressWarnings("serial")
@Namespace("/")
@ParentPackage("json-default")
public class ContactsAction extends ActionSupport implements ModelDriven<SalesContacts>{
	
	@Autowired
	private ContactsService contactsBiz;
	
	private Integer page;//当前页数
	private Integer limit;//显示条数
	private SalesContacts salesContacts = new SalesContacts();//联系人对象
	private Map<String,Object> map = new HashMap();//用于接东西
	
	//分页查询联系人
	@Action(value="selectContactsPage",results={
		@Result(type="json",params= {"root","map"})
	})
	public String selectContactsPage() {
		if (salesContacts.getName() == null) {
			salesContacts.setName("");
		}
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<SalesContacts> list = contactsBiz.selectContactsByPage(salesContacts.getName());
		map.put("data",list);
		map.put("code",0);
		map.put("count",pages.getTotal());
		return SUCCESS;
	}



	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public SalesContacts getSalesContacts() {
		return salesContacts;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public void setSalesContacts(SalesContacts salesContacts) {
		this.salesContacts = salesContacts;
	}
	public SalesContacts getModel() {
		return salesContacts;
	}
	
}
