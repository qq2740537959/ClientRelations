package com.znsd.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Role;
import com.znsd.client.vo.RoleQueryVo;

@Repository
public interface RoleMapperDao {
  
	/**
	 * 
	* @author jlh
	* @param staffName
	* @return
	* @return List<StaffVo>
	* @time 2018 下午7:39:42
	* @desc	分页条件查询角色数据
	*
	 */
	public List<RoleQueryVo> selectRoleByPage(@Param("roleName") String roleName);
	
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
