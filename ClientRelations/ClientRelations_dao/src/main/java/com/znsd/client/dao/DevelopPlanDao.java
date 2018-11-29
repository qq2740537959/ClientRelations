package com.znsd.client.dao;

import java.util.List;

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
	
	public Integer deleteDevelopPlan(@Param("planId")Integer planId);
}
