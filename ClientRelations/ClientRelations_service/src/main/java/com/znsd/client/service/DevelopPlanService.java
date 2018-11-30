package com.znsd.client.service;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 
	* @author Administrator
	* @param plan
	* @return
	* @return Integer
	* @time 2018 下午4:59:52
	* @desc			增加发展计划
	*
	 */
	public Integer insertDevelopPlan(DevelopPlan plan);
	/**
	 * 
	* @author Administrator
	* @param plan
	* @return
	* @return Integer
	* @time 2018 下午5:00:02
	* @desc			修改发展计划
	*
	 */
	public Integer updateDevelopPlan(DevelopPlan plan);
	/**
	 * 
	* @author Administrator
	* @return
	* @return List<Map<String,Object>>
	* @time 2018 下午5:00:09
	* @desc		查询客户姓名和id
	*
	 */
	public List<Map<String, Object>> selectClientName();
	
	/**
	 * 
	* @author Administrator
	* @return
	* @return List<Map<String,Object>>
	* @time 2018 下午3:53:04
	* @desc		客户发展计划用的 查询客户姓名和id
	*
	 */
	public List<Map<String, Object>> selectPlanInClientName();
}
