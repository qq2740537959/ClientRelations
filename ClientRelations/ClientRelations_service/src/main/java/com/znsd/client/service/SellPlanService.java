package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.znsd.client.bean.SellPlan;

public interface SellPlanService {
	/**
	 * 
	*	@author    Administrator
	*	@param roleName
	*	@param sellingId
	*	@param planMonth
	*	@return
	*	@return    List<Map<String,Object>>
	*	@time    2018 下午8:21:37
	*	@desc 分页条件查询
	*
	 */
	 List<Map<String,Object>> selectSellPlanByPage(String roleName,Integer sellingId,String planMonth);
	 
	 /**
	  * 
	 *	@author    Administrator
	 *	@param sellPlan
	 *	@return    void
	 *	@time    2018 下午8:21:48
	 *	@desc 增加销售计划
	 *
	  */
	 void addSellPlan(SellPlan sellPlan) ;
	 
	 /**
	  * 
	 *	@author    Administrator
	 *  @param roleName
	 *  @param handleId
	 *	@param planId
	 *	@return    void
	 *	@time    2018 上午10:36:38
	 *	@desc 提交销售计划
	 *
	  */
	 void subSellPlan(String roleName,Integer handleId,Integer planId);
	 /**
	  * 
	 *	@author    Administrator
	 *	@param planId
	 *	@return    void
	 *	@time    2018 上午11:06:17
	 *	@desc 根据id删除计划
	 *
	  */
	 void delSellPlan(Integer planId);
	 
	 /**
	  * 
	 *	@author    Administrator
	 *	@param sellPlan
	 *	@return    void
	 *	@time    2018 下午7:39:37
	 *	@desc 审核
	 *
	  */
	 void examineSellPlan(SellPlan sellPlan);
	 
	 /**
	  * 
	 *	@author    Administrator
	 *	@param planMonth
	 *	@param sellingId
	 *	@return
	 *	@return    int
	 *	@time    2018 下午10:01:13
	 *	@desc 根据日期和用户计划人id查询计划
	 *
	  */
	 int selectSellDate(String planMonth,Integer sellingId);
	 
	 /**
	  * 
	 *	@author    Administrator
	 *	@param sellPlan
	 *	@return    void
	 *	@time    2018 下午11:30:40
	 *	@desc 修改计划
	 *
	  */
	 void updateSellPlan(SellPlan sellPlan);
}
