package com.znsd.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.vo.StaffVo;

@Repository
public interface StaffMapperDao {
  
	/**
	 * 
	* @author jlh
	* @param staffName
	* @return
	* @return List<StaffVo>
	* @time 2018 下午7:39:42
	* @desc	分页条件查询员工数据
	*
	 */
	public List<StaffVo> selectStaffByPage(@Param("staffName") String staffName);
	
	
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
