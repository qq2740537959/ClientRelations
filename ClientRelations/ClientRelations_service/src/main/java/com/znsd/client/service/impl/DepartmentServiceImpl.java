package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.dao.DepartmentMapperDao;
import com.znsd.client.page.Pages;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.vo.DepartmentVo;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentMapperDao departmentMapperDao;
	
	public List<DepartmentVo> selectDepartmentByPage(String departmentFullname) {
		// TODO Auto-generated method stub
		return departmentMapperDao.selectDepartmentByPage(departmentFullname);
	}

}
