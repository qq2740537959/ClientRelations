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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.Staff;
import com.znsd.client.dao.PinYinHeadUtil;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.service.RoleService;
import com.znsd.client.service.StaffService;
import com.znsd.client.vo.StaffLoginVo;
import com.znsd.client.vo.StaffVo;

@Controller
@SessionAttributes({"userInfo"})
public class StaffController {

	@Autowired
	private StaffService staffBiz;
	
	@Autowired
	private DepartmentService departmentBiz;
	
	@Autowired
	private RoleService roleBiz;
	
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
		if (staff.getContactMode() == "" || staff.getContactMode() == null) {
			map.put("code", 3);
			map.put("msg", "手机号不能为空！");
			return map;
		}
		if (staffLoginVo.getContactMode().equals(staff.getContactMode())) {
			map.put("code", 2);
			map.put("msg", "未做任何修改操作！");
			return map;
		}
		if (!(staff.getContactMode().matches("^1[3456789]\\d{9}$"))) {
			map.put("code", 4);
			map.put("msg", "手机号格式不正确！");
			return map;
		}
		StaffVo staffVo = staffBiz.selectStaffByUserName(staff);
		if (staffVo != null) {
			map.put("code", 0);
			map.put("msg", "手机号已存在！");
		}else {
			staff.setStaffId(staffLoginVo.getStaffId());
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
		if (staff.getUserName() == "" || staff.getUserName() == null) {
			map.put("code", 3);
			map.put("msg", "登录用户名不能为空！");
			return map;
		}
		if (staffLoginVo.getUserName().equals(staff.getUserName())) {
			map.put("code", 2);
			map.put("msg", "未做任何修改操作！");
			return map;
		}
		if (!(staff.getUserName().matches("^(?![\\d]+$)(?![a-zA-Z]+$)(?![!#$%^&*]+$)[\\da-zA-Z!#$%^&*]{6,10}$"))) {
			map.put("code", 4);
			map.put("msg", "登录账号只能是数字+字母组合6-10位！");
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

	//修改员工登录密码
	@RequestMapping("/updatePwd")
	@ResponseBody
	public Map<String, Object> updatePwd(@RequestParam("ypassword") String ypassword,@RequestParam("npassword") String npassword,@RequestParam("twoNewPwd") String twoNewPwd,HttpSession session){
		Map<String, Object> map = new HashMap<>();
		StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
		if (ypassword == "" || ypassword == null || npassword == "" || npassword == null || twoNewPwd == "" || twoNewPwd == null) {
			map.put("code", 0);
			map.put("msg", "请将表单填写完整后提交！");
			return map;
		}
		if (!(ypassword.equals(staffLoginVo.getPassword()))) {
			map.put("code", 2);
			map.put("msg", "原密码输入错误!");
			return map;
		}
		if (npassword.equals(ypassword)) {
			map.put("code", 3);
			map.put("msg", "新密码不能跟旧密码相等!");
			return map;
		}
		if (!(npassword.matches("^[a-zA-Z]\\\\w{5,17}$"))) {
			map.put("code", 4);
			map.put("msg", "新密码格式不正确!");
			return map;
		}
		if (npassword != twoNewPwd) {
			map.put("code", 5);
			map.put("msg", "两次密码输入不一致!");
			return map;
		}
		if (ypassword.equals(staffLoginVo.getPassword())) {
			Staff staff = new Staff();
			staff.setStaffId(staffLoginVo.getStaffId());
			staff.setPassword(npassword);
			staffBiz.updateStaffUserName(staff);
			staffLoginVo.setPassword(npassword);
			session.setAttribute("userInfo", staffLoginVo);
			map.put("code", 1);
			map.put("msg", "修改密码成功!");
			return map;
		}
		return map;
	}
		
	//员工登录
	@RequestMapping("/staffLogin")
	@ResponseBody
	public Map<String, Object> staffLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,ModelMap model){
		Map<String, Object> map = new HashMap<>();
		if (userName == null || userName == "" || password == "" || password == null) {
			map.put("code", 3);
			map.put("msg", "请将表单填写完整后提交！");
			return map;
		}
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
	
	//根据员工Id删除该员工
	@RequestMapping("/deleteStaffById")
	@ResponseBody
	public Map<String, Object> deleteNoticeById(@RequestParam("nArray")String nArray){
		Map<String, Object> map = new HashMap<>();
		String[] spli = nArray.split(",");
		staffBiz.deleteStaffById(spli);
		map.put("code", 1);
		map.put("msg", "删除成功！");
		return map;
	}
	
	//根据员工Id修改员工状态
	@RequestMapping("/updateStaffState")
	@ResponseBody
	public Map<String, Object> updateStaffState(Staff staff){
		Map<String, Object> map = new HashMap<>();
		staffBiz.updateStaffState(staff);
		map.put("code", 1);
		if (staff.getState() == 1) {
			map.put("msg", "已解冻该员工！");
		}else {
			map.put("msg", "已冻结该员工！");
		}
		return map;
	}
	
	//修改或增加员工信息跳转此页面
	@RequestMapping("/intoAddOrUpdateStaffPage")
	public String intoAddOrUpdateStaffPage(Staff staff,ModelMap map) {
		if (staff.getStaffId() != 0) {
			map.put("staff", staffBiz.selectStaffByUserName(staff));
		}
		map.put("roleList", roleBiz.selectRoleByPage(null));
		map.put("departmentList", departmentBiz.selectDepartmentByPage(null));
		return "admin/views/systemManager/addOrUpdateStaff.jsp";
	}
	
	//增加或者修改公告信息
	@RequestMapping("/addOrUpdateStaff")
	@ResponseBody
	public Map<String, Object> addOrUpdateStaff(Staff staff,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		if (staff.getStaffId() != 0) {
			staff.setLastTime(new Date());
			staffBiz.updateStaffUserName(staff);
			map.put("msg", "修改成功！");
		}else {
			StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
			String nameHeadPy = PinYinHeadUtil.getPinYinHeadChar(staff.getStaffName());
			staff.setUserName("admin"+nameHeadPy);
			staff.setPassword("admin"+nameHeadPy);
			staff.setLastTime(new Date());
			staff.setOperationPerson(staffLoginVo.getStaffId());
			staffBiz.addStaff(staff);
			map.put("msg", "增加成功！");
		}
		map.put("code", "1");
		return map;
	}
}
