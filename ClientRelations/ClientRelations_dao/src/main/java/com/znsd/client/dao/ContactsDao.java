package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ContactsDao {
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
	public List<ContactsDao> selectContactsPage(String name);
	/**
	 * 
	*	@author    Administrator
	*	@param name
	*	@return
	*	@return    Long
	*	@time    2018 上午9:27:29
	*	@desc 查询总条数
	*
	 */
	public Long selectContactsCount(String name);
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
	public void updateContacts(ContactsDao sc);
	/**
	 * 
	*	@author    Administrator
	*	@param sc
	*	@return    void
	*	@time    2018 上午9:30:50
	*	@desc 增加联系人
	*
	 */
	public void addContacts(ContactsDao sc);
}
