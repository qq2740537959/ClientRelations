package com.znsd.client.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Staff;
import com.znsd.client.dao.StaffMapperDao;
import com.znsd.client.service.StaffService;
import com.znsd.client.utils.MD5Util;
import com.znsd.client.utils.PinYinHeadUtil;
import com.znsd.client.vo.StaffLoginVo;
import com.znsd.client.vo.StaffVo;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffMapperDao staffDao;
	
	public List<StaffVo> selectStaffByPage(String staffName) {
		// TODO Auto-generated method stub
		return staffDao.selectStaffByPage(staffName);
	}

	@Override
	public List<Map<String, Object>> getStaffDeputyData() {
		// TODO Auto-generated method stub
		return staffDao.getStaffDeputyData();
	}

	@Override
	public StaffLoginVo staffLogin(String userName,String password) {
		// TODO Auto-generated method stub
		password = MD5Util.getMd5(password);
		return staffDao.staffLogin(userName, password);
	}

	@Override
	public StaffVo selectStaffByUserName(Staff staff) {
		// TODO Auto-generated method stub
		return staffDao.selectStaffByUserName(staff);
	}

	@Override
	public void updateStaffUserName(Staff staff) {
		// TODO Auto-generated method stub
		staff.setLastTime(new Date());
		staffDao.updateStaffUserName(staff);
	}

	@Override
	public void deleteStaffById(String nArray) {
		// TODO Auto-generated method stub
		String[] spli = nArray.split(",");
		staffDao.deleteStaffById(spli);
	}

	@Override
	public void updateStaffState(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.updateStaffState(staff);
	}

	@Override
	public void addStaff(Staff staff) {
		// TODO Auto-generated method stub
		String nameHeadPy = PinYinHeadUtil.getPinYinHeadChar(staff.getStaffName());
		staff.setUserName("admin"+nameHeadPy);
		staff.setPassword("admin"+nameHeadPy);
		staff.setCreateTime(new Date());
		staffDao.addStaff(staff);
	}

}
