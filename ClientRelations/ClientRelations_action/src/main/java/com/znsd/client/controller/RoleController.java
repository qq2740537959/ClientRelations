package com.znsd.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.Role;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.service.RoleService;
import com.znsd.client.vo.RoleQueryVo;
import com.znsd.client.vo.StaffLoginVo;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleBiz;
	
	@Autowired
	private DepartmentService departmentBiz;
	
	//分页条件查询角色信息
	@RequestMapping("/queryRoleByPage")
	@ResponseBody
	public Map<String, Object> queryRoleByPage(@RequestParam(value="roleName",required=false) String roleName,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit) {
		Map<String, Object> map = new HashMap<>();
		Page<Object> pages = PageHelper.startPage(page,limit);
		List<RoleQueryVo> list = roleBiz.selectRoleByPage(roleName);
		map.put("code", 0);
		map.put("msg", "查询成功");
		map.put("data", list);
		map.put("count", pages.getTotal());
		return map;
	}
	
	//根据角色Id删除该角色
	@RequestMapping("/deleteRoleById")
	@ResponseBody
	public Map<String, Object> deleteRoleById(@RequestParam("nArray")String nArray){
		Map<String, Object> map = new HashMap<>();
		String[] spli = nArray.split(",");
		roleBiz.deleteRoleById(spli);
		map.put("code", 1);
		map.put("msg", "删除成功！");
		return map;
	}
	
	//修改或增加角色信息跳转此页面
	@RequestMapping("/intoAddOrUpdateRolePage")
	public String intoAddOrUpdateStaffPage(Role role,ModelMap map) {
		if (role.getRoleId() != 0) {
			List<Role> roleList = roleBiz.selectRoleByField(role);
			map.put("roleInfo", roleList.get(0));
		}
		map.put("departmentList", departmentBiz.selectDepartmentByPage(null));
		return "admin/views/systemManager/addOrUpdateRole.jsp";
	}
	
	//增加或者修改角色信息
	@RequestMapping("/addOrUpdateRole")
	@ResponseBody
	public Map<String, Object> addOrUpdateStaff(Role role,HttpSession session) {
		StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
		Map<String, Object> map = new HashMap<>();
		List<Role> rList = null;
		if (role.getRoleId() != 0) {
			/*rList = roleBiz.selectRoleByField(new Role(role.getRoleName()));
			if (rList.size() != 0) {
				if (rList.get(0).getRoleName().equals(role.getRoleName())) {
					
				}else {
					map.put("code", "0");
					map.put("msg", "角色名称已存在！");
					return map;
				}
			}*/
			role.setLastTime(new Date());
			role.setOperationPerson(staffLoginVo.getStaffId());
			roleBiz.updateRoleByField(role);
			map.put("msg", "修改成功！");
		}else {
			rList = roleBiz.selectRoleByField(role);
			if (rList.size() != 0) {
				map.put("code", "0");
				map.put("msg", "角色名称已存在！");
				return map;
			}
			role.setOperationPerson(staffLoginVo.getStaffId());
			role.setLastTime(new Date());
			roleBiz.addRole(role);
			map.put("msg", "增加成功！");
		}
		map.put("code", "1");
		return map;
	}
}
