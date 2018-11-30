package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.dao.RoleMapperDao;
import com.znsd.client.service.RoleService;
import com.znsd.client.vo.DepartmentVo;
import com.znsd.client.vo.RoleQueryVo;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapperDao roleDao;
	
	@Override
	public List<RoleQueryVo> selectRoleByPage(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.selectRoleByPage(roleName);
	}

}
