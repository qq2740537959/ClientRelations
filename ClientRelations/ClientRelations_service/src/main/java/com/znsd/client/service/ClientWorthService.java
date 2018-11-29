package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ClientWorthService {
	/**
	 * 
	* @author Administrator
	* @param clientName
	* @param clientType
	* @return
	* @return List<Map<String,Object>>
	* @time 2018 下午9:20:41
	* @desc		查询客户价值信息
	*
	 */
	public List<Map<String, Object>> selectClientWorthByPage(String clientName,String clientType);
	/**
	 * 
	* @author Administrator
	* @param clientId
	* @return
	* @return Map<String,Object>
	* @time 2018 下午9:20:51
	* @desc		根据id查看客户详细信息
	*
	 */
	public Map<String, Object> selectClientInfo(Integer clientId);
	/**
	 * 
	* @author Administrator
	* @param clientId
	* @return
	* @return List<Map<String,Object>>
	* @time 2018 下午9:21:09
	* @desc			根据客户id查询客户的消费历史记录
	*
	 */
	public List<Map<String, Object>> consumptionHistory(Integer clientId);
}
