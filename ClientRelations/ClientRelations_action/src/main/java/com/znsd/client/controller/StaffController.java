package com.znsd.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.service.StaffService;
import com.znsd.client.vo.StaffLoginVo;
import com.znsd.client.vo.StaffVo;

@Controller
@SessionAttributes("userInfo")
public class StaffController {

	@Autowired
	private StaffService staffBiz;
	
	//分页条件查询员工信息
	@RequestMapping("/selectStaffByPage")
	@ResponseBody
	public Map<String, Object> selectStaffByPage(@RequestParam("page")Integer page,@RequestParam("limit") Integer limit,@RequestParam(value="staffName",required=false) String staffName){
		Map<String, Object> map = new HashMap<>();
		Page<Object> pages = PageHelper.startPage(page,limit);
		List<StaffVo> list = staffBiz.selectStaffByPage(staffName);
		map.put("code", 0);
		map.put("msg", "查询成功");
		map.put("data", list);
		map.put("count", pages.getTotal());
		return map;
	}
	
	@RequestMapping("/staffLogin")
	@ResponseBody
	public Map<String, Object> staffLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,ModelMap model){
		Map<String, Object> map = new HashMap<>();
		StaffLoginVo staffLoginVo = staffBiz.staffLogin(userName, password);
		if (staffLoginVo == null) {
			map.put("code", 1);
			map.put("msg", "用户名或密码错误！");
		} else if (staffLoginVo.getState() == 0) {
			map.put("code", 2);
			map.put("msg", "账号冻结，联系管理员！");
		} else {
			model.addAttribute("userInfo",staffLoginVo);
			map.put("code", 0);
			map.put("msg", "登录成功！");
		}
		return map;
	}
	
}
