package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Department;
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
	public List<DepartmentVo> selectDepartmentByPage(Department department);
	
	/**
	 * 
	* @author jlh
	* @param array
	* @return void
	* @time 2018 上午8:06:41
	* @desc	根据部门Id删除该部门信息
	*
	 */
	public void deleteDepartmentById(String[] array);
	
	/**
	 * 
	* @author jlh
	* @param department
	* @return void
	* @time 2018 上午10:01:44
	* @desc	根据部门表字段动态修改信息
	*
	 */
	public void updateDepartmentByField(Department department);

	/**
	 * 
	* @author jlh
	* @param department
	* @return void
	* @time 2018 上午10:02:32
	* @desc	增加部门信息
	*
	 */
	public void addDepartment(Department department);
}
