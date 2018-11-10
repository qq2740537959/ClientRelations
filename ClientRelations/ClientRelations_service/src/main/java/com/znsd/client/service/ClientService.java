package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.page.Pages;
import com.znsd.client.vo.ClientVo;

public interface ClientService {

	public List<ClientVo> selectClientInfoByPage(int staffId,String clientName,String phone, Pages page); 
}