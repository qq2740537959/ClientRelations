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
}