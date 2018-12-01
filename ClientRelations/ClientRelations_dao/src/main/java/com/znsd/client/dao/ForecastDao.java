package com.znsd.client.dao;

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
	*	@return
	*	@return    int
	*	@time    2018 上午10:07:36
	*	@desc 查询部门客户数量
	*
	 */
	int selectDateClientNumber(@Param("branceId")Integer branceId);
	
	/**
	 * 
	*	@author    Administrator
	*	@param branceId
	*	@return
	*	@return    int
	*	@time    2018 上午10:07:06
	*	@desc 查询部门员工人数
	*
	 */
	int selectDateStaffNumber(@Param("branceId")Integer branceId);
	
}
