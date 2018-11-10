package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.dao.ContactsDao;
import com.znsd.client.service.SalesContactsService;

@Service
public class SalesContactsServiceImpl implements SalesContactsService{
	
	@Autowired
	private ContactsDao dao;

	public List<ContactsDao> selectContactsPage(String name) {
		// TODO Auto-generated method stub
		return dao.selectContactsPage(name);
	}

	public Long selectContactsCount(String name) {
		// TODO Auto-generated method stub
		return dao.selectContactsCount(name);
	}

	public void deleteContacts(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteContacts(id);
	}

	public void updateContacts(ContactsDao sc) {
		// TODO Auto-generated method stub
		dao.updateContacts(sc);
	}

	public void addContacts(ContactsDao sc) {
		// TODO Auto-generated method stub
		dao.addContacts(sc);
	}
	
	
}
