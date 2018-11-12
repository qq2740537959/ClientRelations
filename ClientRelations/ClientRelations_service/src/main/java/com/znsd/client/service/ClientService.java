package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.page.Pages;
import com.znsd.client.vo.ClientVo;

public interface ClientService {
	//按销售代表id查询客户
	public List<ClientVo> selectClientInfoByPage(int staffId,String distinguish,String clientNameOrPhone); 
	
	//按客户id查询客户信息
	public ClientVo selectClientById(int clientId);
}