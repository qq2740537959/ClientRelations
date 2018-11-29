package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.DevelopPlan;

public interface DevelopPlanService {
	/**
	 * 
	* @author Administrator
	* @param month
	* @return
	* @return List<DevelopPlan>
	* @time 2018 上午8:13:44
	* @desc			查询发展计划
	*
	 */
	public List<DevelopPlan> selectDevelopPlan(String month);
		
	/**
	 * 
	* @author Administrator
	* @param planId
	* @return
	* @return Integer
	* @time 2018 上午8:13:31
	* @desc		删除发展计划
	*
	 */
	public Integer deleteDevelopPlan(Integer planId);
}
