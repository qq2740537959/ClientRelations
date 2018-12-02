package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Role;
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

	@Override
	public List<Role> selectRoleByField(Role role) {
		// TODO Auto-generated method stub
		return roleDao.selectRoleByField(role);
	}

	@Override
	public void deleteRoleById(String[] array) {
		// TODO Auto-generated method stub
		roleDao.deleteRoleById(array);
	}

	@Override
	public void updateRoleByField(Role role) {
		// TODO Auto-generated method stub
		roleDao.updateRoleByField(role);
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.addRole(role);
	}

}
