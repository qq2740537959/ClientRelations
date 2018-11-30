package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.Notice;
import com.znsd.client.vo.NoticeVo;

public interface NoticeService {
	/**
	 * 
	* @author jlh
	* @param notice
	* @return
	* @return List<NoticeVo>
	* @time 2018 下午4:44:03
	* @desc	分页条件查询公告
	*
	 */
	public List<NoticeVo> selectNoticeByPage(Notice notice);
	
	/**
	 * 
	* @author jlh
	* @param notice
	* @return void
	* @time 2018 下午8:42:32
	* @desc	根据公告Id删除该公告
	*
	 */
	public void deleteNoticeById(String[] nId);
	
	/**
	 * 
	* @author jlh
	* @param noticeId
	* @return
	* @return NoticeVo
	* @time 2018 下午3:51:22
	* @desc 根据公告Id获取公告信息
	*
	 */
	public NoticeVo selectNoticeById(int noticeId);
	
	/**
	 * 
	* @author jlh
	* @param notice
	* @return void
	* @time 2018 下午4:42:03
	* @desc	根据公告Id修改公告信息
	*
	 */
	public void updateNoticeById(Notice notice);
	
	/**
	 * 
	* @author jlh
	* @param notice
	* @return void
	* @time 2018 下午4:48:09
	* @desc	增加公告信息
	*
	 */
	public void addNotice(Notice notice);
}