package com.znsd.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Forecast;

@Repository
public interface ForecastDao {
	
	/**
	 * 
	*	@author    Administrator
	*	@param forecast
	*	@return    void
	*	@time    2018 上午10:05:44
	*	@desc 预测部门
	*
	 */
	void addForecast(Forecast forecast);
	
	/**
	 * 
	*	@author    Administrator
	*	@param branceId
	*	@param referDate
	*	@return
	*	@return    int
	*	@time    2018 上午10:07:06
	*	@desc 查询部门员工人数
	*
	 */
	int selectDateClientNumber(@Param("branceId")Integer branceId,@Param("referDate") String referDate);
	
	/**
	 * 
	*	@author    Administrator
	*	@param branceId
	*	@param referDate
	*	@return
	*	@return    int
	*	@time    2018 上午10:07:36
	*	@desc 查询部门客户数量   
	*							
	 */
	int selectDateStaffNumber(@Param("branceId")Integer branceId,@Param("referDate") String referDate);
	
	/**
	 * 
	*	@author    Administrator
	*	@param startTime
	*	@return
	*	@return    List<Map<String,Object>>
	*	@time    2018 下午9:57:06
	*	@desc 分页查询
	*
	 */
	List<Map<String,Object>> selectForecastByPage(@Param("startTime") String startTime);
}
