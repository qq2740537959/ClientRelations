package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Notice;
import com.znsd.client.dao.NoticeMapperDao;
import com.znsd.client.service.NoticeService;
import com.znsd.client.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapperDao noticeDao;
	
	@Override
	public List<NoticeVo> selectNoticeByPage(Notice notice) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeByPage(notice);
	}

}
