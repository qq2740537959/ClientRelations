package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import com.znsd.client.vo.StaffVo;

public interface StaffService {
	/**
	 * 
	* @author jlh
	* @param staffName
	* @return
	* @return List<StaffVo>
	* @time 2018 下午7:56:31
	* @desc	分页条件查询员工
	*
	 */
	public List<StaffVo> selectStaffByPage(String staffName);


	/**
	 * 
	*	@author    Administrator
	*	@return 
	*	@return    List<Map<String,Object>>
	*	@time    2018 下午8:48:00
	*	@desc 查询销售代表
	*
	 */
	List<Map<String,Object>> getStaffDeputyData();
}
