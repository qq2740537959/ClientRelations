package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Department;
import com.znsd.client.dao.DepartmentMapperDao;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.vo.DepartmentVo;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentMapperDao departmentMapperDao;
	
	public List<DepartmentVo> selectDepartmentByPage(Department department) {
		// TODO Auto-generated method stub
		return departmentMapperDao.selectDepartmentByPage(department);
	}

	@Override
	public void deleteDepartmentById(String[] array) {
		// TODO Auto-generated method stub
		departmentMapperDao.deleteDepartmentById(array);
	}

	@Override
	public void updateDepartmentByField(Department department) {
		// TODO Auto-generated method stub
		departmentMapperDao.updateDepartmentByField(department);
	}

	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapperDao.addDepartment(department);
	}

}
