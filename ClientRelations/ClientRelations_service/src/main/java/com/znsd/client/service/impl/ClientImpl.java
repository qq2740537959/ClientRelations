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
	
	@Override
	public List<ClientVo> selectClientInfoByPage(int staffId,String distinguish,String clientNameOrPhone) {
		////按销售代表id查询客户
		return dao.selectClientInfoByPage(staffId,distinguish, clientNameOrPhone);
	}
	@Override
	public ClientVo selectClientById(int clientId) {
		//按客户id查询客户信息
		return dao.selectClientById(clientId);
	}
	/**
	 * 分页查询所有客户资源
	 */
	@Override
	public List<Map<String, Object>> selectAllClientByPage(Integer allotState,String conditionName,String condition,int roleId,int staffId) {
		if ("clientName".equals(conditionName)) {
			conditionName = "client_name";
		}
		return dao.selectAllClientByPage(allotState,conditionName,condition,roleId,staffId);
	}
	@Override
	public Integer addResource(ClientResource resource) {
		return dao.addResource(resource);
	}
	
	@Override
	public Integer updateResource(ClientResource resource) {
		return dao.updateResource(resource);
	}

	@Override
	public List<Map<String, Object>> selectResourceState() {
		Integer allotState = 1;
		Integer state = 1;
		return dao.selectResourceState(allotState, state);
	}
	@Override		// 分配
	public Integer updateStaffId(Integer staffId, Integer chanceId) {
		return dao.updateStaffId(staffId, chanceId);
	}
	@Override		// 客户机会
	public Integer updateChanceId(Integer chanceId, Integer clientId) {
		return dao.updateChanceId(chanceId, clientId);
	}

}
