package com.znsd.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.bean.DevelopPlan;

@Repository
public interface DevelopPlanDao {
	/**
	 * 
	* @author Administrator
	* @param month
	* @return
	* @return List<DevelopPlan>
	* @time 2018 下午11:43:54
	* @desc			查询发展计划
	*
	 */
	public List<DevelopPlan> selectDevelopPlan(@Param("month")String month);
	/**
	 * 
	* @author Administrator
	* @param planId
	* @return
	* @return Integer
	* @time 2018 下午4:46:51
	* @desc		撤销发展计划
	*
	 */
	public Integer deleteDevelopPlan(@Param("planId")Integer planId);
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
}