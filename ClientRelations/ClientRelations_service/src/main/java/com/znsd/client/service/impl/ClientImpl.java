package com.znsd.client.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.dao.ClientResourceMapperDao;
import com.znsd.client.page.Pages;
import com.znsd.client.service.ClientService;
import com.znsd.client.vo.ClientVo;

@Service
public class ClientImpl implements ClientService{
	
	@Autowired
	private ClientResourceMapperDao dao;
	
	public List<ClientVo> selectClientInfoByPage(int staffId,String clientName,String phone,Pages page) {
		return dao.selectClientInfoByPage(staffId,clientName, phone,page);
	}

}
