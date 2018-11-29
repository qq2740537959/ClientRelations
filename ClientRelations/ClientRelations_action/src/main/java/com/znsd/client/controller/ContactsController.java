package com.znsd.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.SalesContacts;
import com.znsd.client.service.ContactsService;

@Controller
public class ContactsController {
	
	@Autowired
	private ContactsService contactsBiz;
	
	private Map<String,Object> map = new HashMap();//用于接东西
	//分页查询联系人selectContactsPage
	@RequestMapping("selectContactsPage")
	@ResponseBody
	public Map<String,Object> selectContactsPage(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam(name="name",required=false) String name) {
		if (name == null) {
			name = "";
		}
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<SalesContacts> list = contactsBiz.selectContactsByPage(name);
		map.put("data",list);
		map.put("code",0);
		map.put("count",pages.getTotal());
		return map;
	}
	//删除联系人delContacts
	@RequestMapping("delContacts")
	@ResponseBody
	public Map<String,Object> delContacts(SalesContacts salesContacts) {
		contactsBiz.deleteContacts(salesContacts.getContactsId());
		map.put("msg","删除成功");
		return map;
	}
	//修改联系人updateContacts
	@RequestMapping("updateContacts")
	@ResponseBody
	public Map<String,Object> updateContacts(SalesContacts salesContacts) {
		contactsBiz.updateContacts(salesContacts);
		map.put("msg","修改成功");
		return map;
	}
	//增加联系人 addContacts
	@RequestMapping("addContacts")
	@ResponseBody
	public Map<String,Object> addContacts(SalesContacts salesContacts) {
		contactsBiz.addContacts(salesContacts);
		map.put("msg","增加成功");
		return map;
	}
	//根据id查询联系人getContactsData
	@RequestMapping("getContactsData")
	@ResponseBody
	public Map<String,Object> getContactsData(SalesContacts salesContacts) {
		map.put("data",contactsBiz.getContactsData(salesContacts.getContactsId()));
		
		return map;
	}
	public ContactsService getContactsBiz() {
		return contactsBiz;
	}
	public void setContactsBiz(ContactsService contactsBiz) {
		this.contactsBiz = contactsBiz;
	}
	

	
}
