package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.znsd.client.bean.Hap;

public interface HapService {
	/**
	 * 
	*	@author    Administrator
	*	@param chanceName
	*	@return
	*	@return    List<Map<String,Object>>
	*	@time    2018 下午3:54:06
	*	@desc 分页查询机会
	*
	 */
	List<Map<String,Object>> selectHapByPage(String chanceName);

	/**
	 * 
	*	@author    Administrator
	*	@param staffId
	*   @param handleId
	*	@param chanceId
	*	@return    void
	*	@time    2018 下午4:36:54
	*	@desc 分配机会
	*
	 */
	void updateAllotHap(@Param("staffId")Integer staffId,@Param("handleId")Integer handleId ,@Param("chanceId") Integer chanceId);
	
	/**
	 * 
	*	@author    Administrator
	*	@param chanceId
	*	@return    Map<String,Object>
	*	@time    2018 下午8:49:42
	*	@desc 根据id查询机会
	*
	 */
	Map<String,Object> getHapData(Integer chanceId);
	
	/**
	 * 
	*	@author    Administrator
	*	@param hap
	*	@return    void
	*	@time    2018 上午10:40:48
	*	@desc 修改机会内容
	*
	 */
	void updateHap(Hap hap);
	
	/**
	 * 
	*	@author    Administrator
	*	@param hap
	*	@return    Integer
	*	@time    2018 下午9:55:07
	*	@desc 增加机会
	*
	 */
	Integer addHap(Hap hap);
}
