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
import com.znsd.client.bean.Department;
import com.znsd.client.bean.Staff;
import com.znsd.client.dao.PinYinHeadUtil;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.vo.DepartmentVo;
import com.znsd.client.vo.StaffLoginVo;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentBiz;
	
	//分页条件查询组织结构
	@RequestMapping("/queryDepartmentByPage")
	@ResponseBody
	public Map<String, Object> queryDepartmentByPage(Department department,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit) {
		Map<String, Object> map = new HashMap<>();
		Page<Object> pages = PageHelper.startPage(page,limit);
		List<DepartmentVo> list = departmentBiz.selectDepartmentByPage(department);
		map.put("code", 0);
		map.put("msg", "查询成功");
		map.put("data", list);
		map.put("count", pages.getTotal());
		return map;
	}
	
	//根据部门Id删除该部门
	@RequestMapping("/deleteDepartmentById")
	@ResponseBody
	public Map<String, Object> deleteDepartmentById(@RequestParam("nArray")String nArray){
		Map<String, Object> map = new HashMap<>();
		String[] spli = nArray.split(",");
		departmentBiz.deleteDepartmentById(spli);
		map.put("code", 1);
		map.put("msg", "删除成功！");
		return map;
	}
	
	//修改或增加部门信息跳转此页面
	@RequestMapping("/intoAddOrUpdateDepartmentPage")
	public String intoAddOrUpdateDepartmentPage(Department department,ModelMap map) {
		if (department.getDepartmentId() != 0) {
			List<DepartmentVo> dList =  departmentBiz.selectDepartmentByPage(department);
			map.put("department", dList.get(0));
		}
		map.put("departmentList", departmentBiz.selectDepartmentByPage(null));
		return "admin/views/systemManager/addOrUpdateDepartment.jsp";
	}
	
	//增加或者修改公告信息
	@RequestMapping("/addOrUpdateDepartment")
	@ResponseBody
	public Map<String, Object> addOrUpdateDepartment(Department department,HttpSession session) {
		StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
		Map<String, Object> map = new HashMap<>();
		if (department.getDepartmentId() != 0) {
			department.setLastTime(new Date());
			department.setOperationPerson(staffLoginVo.getStaffId());
			departmentBiz.updateDepartmentByField(department);
			map.put("msg", "修改成功！");
		}else {
			department.setLastTime(new Date());
			department.setOperationPerson(staffLoginVo.getStaffId());
			departmentBiz.addDepartment(department);
			map.put("msg", "增加成功！");
		}
		map.put("code", "1");
		return map;
	}
}
