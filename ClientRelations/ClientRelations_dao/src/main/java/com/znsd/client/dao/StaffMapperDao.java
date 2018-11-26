package com.znsd.client.dao;

import java.util.List;

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
	public List<StaffVo> selectStaffByPage(String staffName);
}
