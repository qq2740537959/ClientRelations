package com.znsd.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.vo.DepartmentVo;

/**
 * 
 * @author Administrator
 *	组织结构dao
 */
@Repository
public interface DepartmentMapperDao {
	
	/**
	 * 
	* @author jlh
	* @return
	* @return List<DepartmentVo>
	* @time 2018 上午11:05:12
	* @desc	条件查询组织结构并分页查询组织结构数据
	*
	 */
	public List<DepartmentVo> selectDepartmentByPage(@Param("departmentFullname")String departmentFullname);
}
