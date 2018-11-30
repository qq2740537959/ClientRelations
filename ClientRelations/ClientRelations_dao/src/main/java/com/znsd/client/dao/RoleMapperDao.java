package com.znsd.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.vo.RoleQueryVo;
import com.znsd.client.vo.StaffLoginVo;
import com.znsd.client.vo.StaffVo;

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
	
}
