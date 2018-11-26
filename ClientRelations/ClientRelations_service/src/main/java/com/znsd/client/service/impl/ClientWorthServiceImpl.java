package com.znsd.client.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.dao.ClientWorthDao;
import com.znsd.client.service.ClientWorthService;

@Service
public class ClientWorthServiceImpl implements ClientWorthService {

	@Autowired
	private ClientWorthDao dao;
	
	public List<Map<String, Object>> selectClientWorthByPage(String clientName,String clientType) {
		return dao.selectClientWorthByPage(clientName,clientType);
	}

}
