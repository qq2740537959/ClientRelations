package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.dao.StaffMapperDao;
import com.znsd.client.service.StaffService;
import com.znsd.client.vo.StaffVo;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffMapperDao staffDao;
	
	public List<StaffVo> selectStaffByPage(String staffName) {
		// TODO Auto-generated method stub
		return staffDao.selectStaffByPage(staffName);
	}

}
