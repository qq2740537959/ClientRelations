package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.SalesContacts;
import com.znsd.client.dao.ContactsDao;
import com.znsd.client.service.ContactsService;

@Service
public class ContactsServiceImpl implements ContactsService{
	@Autowired
	private ContactsDao dao;

	public List<SalesContacts> selectContactsByPage(String name) {
		// TODO Auto-generated method stub
		return dao.selectContactsByPage(name);
	}

	public void deleteContacts(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteContacts(id);
	}

	public void updateContacts(SalesContacts sc) {
		// TODO Auto-generated method stub
		dao.updateContacts(sc);
	}

	public void addContacts(SalesContacts sc) {
		// TODO Auto-generated method stub
		dao.addContacts(sc);
	}

	public SalesContacts getContactsData(Integer id) {
		// TODO Auto-generated method stub
		return dao.getContactsData(id);
	}

	
	
}
