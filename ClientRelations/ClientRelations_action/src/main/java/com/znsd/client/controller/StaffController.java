package com.znsd.client.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.Staff;
import com.znsd.client.service.StaffService;
import com.znsd.client.vo.StaffLoginVo;
import com.znsd.client.vo.StaffVo;

@Controller
@SessionAttributes({"userInfo"})
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
	
	//修改员工手机号
	@RequestMapping("/updateStaffPhone")
	@ResponseBody
	public Map<String, Object> updateStaffPhone(Staff staff,HttpSession session){
		Map<String, Object> map = new HashMap<>();
		StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
		if (staffLoginVo.getContactMode().equals(staff.getContactMode())) {
			map.put("code", 2);
			map.put("msg", "未做任何修改操作！");
			return map;
		}
		StaffVo staffVo = staffBiz.selectStaffByUserName(staff);
		if (staffVo != null) {
			map.put("code", 0);
			map.put("msg", "手机号已存在！");
		}else {
			staff.setStaffId(staffLoginVo.getStaffId());
			System.out.println(staff+"-----");
			staffBiz.updateStaffUserName(staff);
			staffLoginVo.setContactMode(staff.getContactMode());
			session.setAttribute("userInfo", staffLoginVo);
			map.put("code", 1);
			map.put("msg", "修改手机号成功！");
		}
		return map;
	}
	
	//修改员工登录用户名
		@RequestMapping("/updateStaffUserName")
		@ResponseBody
		public Map<String, Object> updateStaffUserName(Staff staff,HttpSession session){
			Map<String, Object> map = new HashMap<>();
			StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
			if (staffLoginVo.getUserName().equals(staff.getUserName())) {
				map.put("code", 2);
				map.put("msg", "未做任何修改操作！");
				return map;
			}
			StaffVo staffVo = staffBiz.selectStaffByUserName(staff);
			if (staffVo != null) {
				map.put("code", 0);
				map.put("msg", "用户名已存在！");
			}else {
				staff.setStaffId(staffLoginVo.getStaffId());
				staffBiz.updateStaffUserName(staff);
				staffLoginVo.setUserName(staff.getUserName());
				session.setAttribute("userInfo", staffLoginVo);
				map.put("code", 1);
				map.put("msg", "修改登录用户名成功！");
			}
			return map;
		}
	
	//员工登录
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
			model.put("userInfo",staffLoginVo);
			map.put("code", 0);
			map.put("msg", "登录成功！");
		}
		return map;
	}
	
	//员工退出登录
	@RequestMapping("/userExit")
	public String userExit(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
}
