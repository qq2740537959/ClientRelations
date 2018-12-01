package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.znsd.client.bean.Staff;
import com.znsd.client.vo.StaffLoginVo;
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
	
	/**
	 * 
	* @author jlh
	* @return
	* @return StaffLoginVo
	* @time 2018 上午10:10:14
	* @desc	员工登录
	*
	 */
	public StaffLoginVo staffLogin(String userName,String password);
	
	/**
	 * 
	* @author jlh
	* @return
	* @return StaffLoginVo
	* @time 2018 下午8:58:19
	* @desc	根据员工表字段获取数据 
	*
	 */
	public StaffVo selectStaffByUserName(Staff staff);
	
	/**
	 * 
	* @author jlh
	* @param staff
	* @return void
	* @time 2018 下午9:00:18
	* @desc	根据员工表字段动态修改信息
	*
	 */
	public void updateStaffUserName(Staff staff);
	
	/**
	 * 
	* @author jlh
	* @param notice
	* @return void
	* @time 2018 下午8:41:44
	* @desc 根据员工Id删除该员工信息
	*
	 */
	public void deleteStaffById(String[] array);
	
	/**
	 * 
	* @author jlh
	* @param staff
	* @return void
	* @time 2018 下午5:51:23
	* @desc	根据员工Id修改员工状态
	*
	 */
	public void updateStaffState(Staff staff);
	
	/**
	 * 
	* @author jlh
	* @param staff
	* @return void
	* @time 2018 下午8:16:17
	* @desc	增加员工信息
	*
	 */
	public void addStaff(Staff staff);
}
