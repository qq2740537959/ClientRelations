package com.znsd.client.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Staff;
import com.znsd.client.dao.StaffMapperDao;
import com.znsd.client.service.StaffService;
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
		staffDao.updateStaffUserName(staff);
	}

	@Override
	public void deleteStaffById(String[] array) {
		// TODO Auto-generated method stub
		staffDao.deleteStaffById(array);
	}

	@Override
	public void updateStaffState(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.updateStaffState(staff);
	}

	@Override
	public void addStaff(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.addStaff(staff);
	}

}
