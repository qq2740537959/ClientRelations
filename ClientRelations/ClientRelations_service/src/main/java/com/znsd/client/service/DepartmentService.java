package com.znsd.client.service;

import java.util.List;

import com.znsd.client.vo.DepartmentVo;

public interface DepartmentService {
	/**
	 * 
	* @author jlh
	* @param page
	* @param department
	* @return
	* @return List<DepartmentVo>
	* @time 2018 上午11:18:47
	* @desc	条件查询组织结构并分页查询组织结构数据
	*
	 */
	public List<DepartmentVo> selectDepartmentByPage(String departmentFullname);
}
