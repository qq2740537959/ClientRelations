package com.znsd.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientWorthDao {
	/**
	 * 
	* @author Administrator
	* @param clientName
	* @param clientType
	* @return
	* @return List<Map<String,Object>>
	* @time 2018 下午9:11:49
	* @desc			 价值信息
	*
	 */
	public List<Map<String, Object>> selectClientWorthByPage(@Param(value="clientName") String clientName,@Param(value="clientType") String clientType);
	/**
	 * 
	* @author Administrator
	* @param clientId
	* @return
	* @return Map<String,Object>
	* @time 2018 下午9:14:27
	* @desc		id查询客户信息
	*
	 */
	public Map<String, Object> selectClientInfo(@Param(value="clientId") Integer clientId);
	/**
	 * 
	* @author Administrator
	* @param clientId
	* @return
	* @return List<Map<String,Object>>
	* @time 2018 下午9:14:38
	* @desc		根据客户id查询客户的消费历史
	*
	 */
	public List<Map<String, Object>> consumptionHistory(@Param(value="clientId") Integer clientId);
}
