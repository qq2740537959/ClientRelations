package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.vo.ClientVo;

public interface ClientService {
	//按销售代表id查询客户
	public List<ClientVo> selectClientInfoByPage(int staffId,String distinguish,String clientNameOrPhone); 
	
	//按客户id查询客户信息
	public ClientVo selectClientById(int clientId);
	
	/**
	 * 
	* @author dengjialei
	* @return	
	* @return List<Map<String,Object>>
	* @time 2018 下午8:40:23
	* @desc		查询所有客户资源
	*
	 */
	public List<Map<String, Object>> selectAllClientByPage(Integer allotState,String conditionName,String condition);
	
	/**
	 * 
	* @author Administrator
	* @param resource
	* @return
	* @return Integer
	* @time 2018 上午10:19:37
	* @desc			增加客户资源
	*
	 */
	public Integer addResource(ClientResource resource);
		
	/**
	 * 
	* @author Administrator
	* @param resource
	* @return
	* @return Integer
	* @time 2018 下午3:39:58	
	* @desc			修改客户资源
	*
	 */
	public Integer updateResource(ClientResource resource);
	
	//查询未分配和正常状态的客户
	public List<Map<String, Object>> selectResourceState();
}