package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Notice;
import com.znsd.client.vo.NoticeVo;

@Repository
public interface NoticeMapperDao {
  
	/**
	 * 
	* @author jlh
	* @param notice
	* @return
	* @return NoticeVo
	* @time 2018 下午4:39:35
	* @desc	分页条件查询公告
	*
	 */
	public List<NoticeVo> selectNoticeByPage(Notice notice);
	
	/**
	 * 
	* @author jlh
	* @param notice
	* @return void
	* @time 2018 下午8:41:44
	* @desc 根据公告Id删除该公告
	*
	 */
	public void deleteNoticeById(String[] array);
}
