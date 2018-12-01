package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.Role;
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
	
	/**
	 * 
	* @author jlh
	* @param role
	* @return
	* @return List<Role>
	* @time 2018 上午10:30:47
	* @desc	根据角色表字段查询角色信息
	*
	 */
	public List<Role> selectRoleByField(Role role);
	
	/**
	 * 
	* @author jlh
	* @param array
	* @return void
	* @time 2018 上午10:50:34
	* @desc	根据角色Id删除角色信息
	*
	 */
	public void deleteRoleById(String[] array);
	
	/**
	 * 
	* @author jlh
	* @param role
	* @return void
	* @time 2018 上午10:55:37
	* @desc	根据角色表结构修改角色信息
	*
	 */
	public void updateRoleByField(Role role);
	
	/**
	 * 
	* @author jlh
	* @param role
	* @return void
	* @time 2018 上午11:18:11
	* @desc	增加角色信息
	*
	 */
	public void addRole(Role role);
}
