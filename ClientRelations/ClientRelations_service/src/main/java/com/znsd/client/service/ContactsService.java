package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.SalesContacts;
import com.znsd.client.page.Pages;

public interface ContactsService {
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    List<SalesContacts>
	*	@time    2018 上午9:25:25
	*	@desc 分页条件查询联系人
	*
	 */
	public List<SalesContacts> selectContactsByPage(String name);
	
	/**
	 * 
	*	@author    Administrator
	*	@param id
	*	@return
	*	@return    SalesContacts
	*	@time    2018 下午5:18:31
	*	@desc 根据id查询联系人
	*
	 */
	public SalesContacts getContactsData(Integer id);
	
	/**
	 * 
	*	@author    Administrator
	*	@param id
	*	@return    void
	*	@time    2018 上午9:28:43
	*	@desc 删除联系人
	*
	 */
	public void deleteContacts(Integer id);
	/**
	 * 
	*	@author    Administrator
	*	@param sc
	*	@return    void
	*	@time    2018 上午9:29:46
	*	@desc 修改联系人的信息
	*
	 */
	public void updateContacts(SalesContacts sc);
	/**
	 * 
	*	@author    Administrator
	*	@param sc
	*	@return    void
	*	@time    2018 上午9:30:50
	*	@desc 增加联系人
	*
	 */
	public void addContacts(SalesContacts sc);
}
