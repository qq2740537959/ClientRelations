package com.znsd.client.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.dao.ClientResourceMapperDao;
import com.znsd.client.service.ClientService;
import com.znsd.client.vo.ClientVo;

@Service
public class ClientImpl implements ClientService{
	
	@Autowired
	private ClientResourceMapperDao dao;
	
	public List<ClientVo> selectClientInfoByPage(int staffId,String distinguish,String clientNameOrPhone) {
		////按销售代表id查询客户
		return dao.selectClientInfoByPage(staffId,distinguish, clientNameOrPhone);
	}

	public ClientVo selectClientById(int clientId) {
		//按客户id查询客户信息
		return dao.selectClientById(clientId);
	}

	public List<Map<String, Object>> selectAllClientByPage(Integer allotState,String conditionName,String condition) {
		if ("clientName".equals(conditionName)) {
			conditionName = "client_name";
		}
		return dao.selectAllClientByPage(allotState,conditionName,condition);
	}

	public Integer addResource(ClientResource resource) {
		return dao.addResource(resource);
	}

}
