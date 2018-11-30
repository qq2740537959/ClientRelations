package com.znsd.client.service;

import java.util.List;

import com.znsd.client.vo.RoleQueryVo;

public interface RoleService {
	/**
	 * 
	* @author jlh
	* @param page
	* @param department
	* @return
	* @return List<DepartmentVo>
	* @time 2018 上午11:18:47
	* @desc	分页条件查询角色信息
	*
	 */
	public List<RoleQueryVo> selectRoleByPage(String roleName);
}
