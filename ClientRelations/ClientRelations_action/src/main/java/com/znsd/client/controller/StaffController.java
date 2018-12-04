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
import com.znsd.client.service.DepartmentService;
import com.znsd.client.service.RoleService;
import com.znsd.client.service.StaffService;
import com.znsd.client.utils.Constant;
import com.znsd.client.utils.MD5Util;
import com.znsd.client.utils.Result;
import com.znsd.client.utils.ResultUtil;
import com.znsd.client.vo.StaffLoginVo;
import com.znsd.client.vo.StaffVo;

@Controller
@SessionAttributes({"userInfo"})
public class StaffController {

	private static Map<String, Object> map = new HashMap<String,Object>();
	
	@Autowired
	private StaffService staffBiz;
	
	@Autowired
	private DepartmentService departmentBiz;
	
	@Autowired
	private RoleService roleBiz;
	
	/**
	 * 	
	* @author jlh
	* @param page
	* @param limit
	* @param staffName
	* @return
	* @return Map<String,Object>
	* @time 2018 下午9:17:23
	* @desc	分页条件查询员工信息
	*
	 */
	@RequestMapping("/selectStaffByPage")
	@ResponseBody
	public Map<String, Object> selectStaffByPage(@RequestParam("page")Integer page,@RequestParam("limit") Integer limit,@RequestParam(value="staffName",required=false) String staffName){
		Page<Object> pages = PageHelper.startPage(page,limit);
		List<StaffVo> list = staffBiz.selectStaffByPage(staffName);
		map.put("code", 0);
		map.put("msg", "查询成功");
		map.put("data", list);
		map.put("count", pages.getTotal());
		return map;
	}
	
	/**
	 * 
	* @author jlh
	* @param staff
	* @param session
	* @return
	* @return Result
	* @time 2018 下午9:17:16
	* @desc	修改员工手机号
	*
	 */
	@RequestMapping("/updateStaffPhone")
	@ResponseBody
	public Result updateStaffPhone(Staff staff,HttpSession session){
		StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
		if (staff.getContactMode() == "" || staff.getContactMode() == null) {
			return ResultUtil.error(Constant.STATE3, Constant.PHONE_NOT_EMPTY);
		}
		if (staffLoginVo != null && staffLoginVo.getContactMode().equals(staff.getContactMode())) {
			return ResultUtil.error(Constant.STATE2, Constant.NOT_DO_OPERATE);
		}
		if (!(staff.getContactMode().matches("^1[3456789]\\d{9}$"))) {
			return ResultUtil.error(Constant.STATE4, Constant.PHONE_FORMAT_INCORRECT);
		}
		StaffVo staffVo = staffBiz.selectStaffByUserName(staff);
		if (staffVo != null) {
			return ResultUtil.error(Constant.ZERO, Constant.PHONE_EXIST);
		}
		staff.setStaffId(staffLoginVo.getStaffId());
		staffBiz.updateStaffUserName(staff);
		staffLoginVo.setContactMode(staff.getContactMode());
		session.setAttribute("userInfo", staffLoginVo);
		return ResultUtil.error(Constant.STATE1, Constant.UPDATE_SUCCESS);
	}
	
	/**
	 * 
	* @author jlh
	* @param staff
	* @param session
	* @return
	* @return Result
	* @time 2018 下午9:17:04
	* @desc	修改员工登录用户名
	*
	 */
	@RequestMapping("/updateStaffUserName")
	@ResponseBody
	public Result updateStaffUserName(Staff staff,HttpSession session){
		StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
		if (staff.getUserName() == "" || staff.getUserName() == null) {
			return ResultUtil.error(Constant.STATE3, Constant.ACCOUNT_NOT_EMPTY);
		}
		if (staffLoginVo.getUserName().equals(staff.getUserName())) {
			return ResultUtil.error(Constant.STATE2, Constant.NOT_DO_OPERATE);
		}
		if (!(staff.getUserName().matches("^(?![\\d]+$)(?![a-zA-Z]+$)(?![!#$%^&*]+$)[\\da-zA-Z!#$%^&*]{6,10}$"))) {
			return ResultUtil.error(Constant.STATE4, Constant.ACCOUNT_REGULAR_EXPRESSION);
		}
		StaffVo staffVo = staffBiz.selectStaffByUserName(staff);
		if (staffVo != null) {
			return ResultUtil.error(Constant.ZERO, Constant.ACCOUNT_EXIST);
		}
		staff.setStaffId(staffLoginVo.getStaffId());
		staffBiz.updateStaffUserName(staff);
		staffLoginVo.setUserName(staff.getUserName());
		session.setAttribute("userInfo", staffLoginVo);
		return ResultUtil.success(Constant.STATE1, Constant.UPDATE_SUCCESS);
	}

	/**
	 * 
	* @author jlh
	* @param ypassword
	* @param npassword
	* @param twoNewPwd
	* @param session
	* @return
	* @return Result
	* @time 2018 下午9:16:20
	* @desc	修改员工登录密码
	*
	 */
	@RequestMapping("/updatePwd")
	@ResponseBody
	public Result updatePwd(@RequestParam("ypassword") String ypassword,@RequestParam("npassword") String npassword,@RequestParam("twoNewPwd") String twoNewPwd,HttpSession session){
		if (ypassword == "" || ypassword == null || npassword == "" || npassword == null || twoNewPwd == "" || twoNewPwd == null) {
			return ResultUtil.error(Constant.STATE3, Constant.FORM_EMPTY);
		}
		StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
		if (!(MD5Util.getMd5(ypassword).equals(staffLoginVo.getPassword()))) {
			return ResultUtil.error(Constant.STATE2, Constant.PRIMARY_PASSWORD_ERROR);
		}
		if (MD5Util.getMd5(npassword).equals(MD5Util.getMd5(ypassword))) {
			return ResultUtil.error(Constant.STATE3, Constant.NEW_OLD_PASSWORD_CANNOT_EQALS);
		}
		if (!(npassword.matches("^[a-zA-Z]\\w{5,17}$"))) {
			return ResultUtil.error(Constant.STATE3, Constant.NEW_PASSWORD_FORMAT_INCORRECT);
		}
		if (!(npassword.equals(twoNewPwd))) {
			return ResultUtil.error(Constant.STATE5, Constant.TWO_PASSWORD_ATYPISM);
		}
		npassword = MD5Util.getMd5(npassword);
		staffBiz.updateStaffUserName(new Staff(staffLoginVo.getStaffId(),npassword));
		staffLoginVo.setPassword(npassword);
		session.setAttribute("userInfo", staffLoginVo);
		return ResultUtil.success(Constant.STATE1, Constant.UPDATE_SUCCESS);
	}
		
	/**
	 * 
	* @author jlh
	* @param userName
	* @param password
	* @param model
	* @return
	* @return Result
	* @time 2018 下午9:16:06
	* @desc	员工登录
	*
	 */
	@RequestMapping("/staffLogin")
	@ResponseBody
	public Result staffLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,ModelMap model){
		if (userName == null || userName == "" || password == "" || password == null) {
			return ResultUtil.error(Constant.STATE3, Constant.FORM_EMPTY);
		}
		StaffLoginVo staffLoginVo = staffBiz.staffLogin(userName, password);
		if (staffLoginVo == null) {
			return ResultUtil.error(Constant.STATE1, Constant.LOGIN_ERROR);
		} else if (staffLoginVo != null && staffLoginVo.getState() == 0) {
			return ResultUtil.error(Constant.STATE2, Constant.ACCOUNT_FROZEN);
		}
		model.put("userInfo",staffLoginVo);
		return ResultUtil.success(Constant.ZERO,Constant.LOGIN_SUCCESS);
	}
	
	/**
	 * 
	* @author jlh
	* @param sessionStatus
	* @return
	* @return String
	* @time 2018 下午9:15:38
	* @desc	员工退出登录
	*
	 */
	@RequestMapping("/userExit")
	public String userExit(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	/**
	 * 
	* @author jlh
	* @param nArray
	* @return
	* @return Result
	* @time 2018 下午9:13:30
	* @desc	根据员工Id删除该员工
	*
	 */
	@RequestMapping("/deleteStaffById")
	@ResponseBody
	public Result deleteNoticeById(@RequestParam("nArray")String nArray){
		staffBiz.deleteStaffById(nArray);
		return ResultUtil.success(Constant.STATE1,Constant.DELETE_SUCCESS);
	}
	
	/**
	 * 
	* @author jlh
	* @param staff
	* @return
	* @return Result
	* @time 2018 下午9:13:23
	* @desc 根据员工Id修改员工状态
	*
	 */
	@RequestMapping("/updateStaffState")
	@ResponseBody
	public Result updateStaffState(Staff staff){
		staffBiz.updateStaffState(staff);
		return ResultUtil.success(Constant.STATE1, Constant.OPERATE_SUCCESS);
	}
	
	/**
	 * 
	* @author jlh
	* @param staff
	* @param map
	* @return
	* @return String
	* @time 2018 下午8:07:05
	* @desc	修改或增加员工信息跳转此页面
	*
	 */
	@RequestMapping("/intoAddOrUpdateStaffPage")
	public String intoAddOrUpdateStaffPage(Staff staff,ModelMap map) {
		if (staff != null && staff.getStaffId() != 0) {
			map.put("staffInfo", staffBiz.selectStaffByUserName(staff));
		}
		map.put("roleList", roleBiz.selectRoleByPage(null));
		map.put("departmentList", departmentBiz.selectDepartmentByPage(null));
		return "admin/views/systemManager/addOrUpdateStaff.jsp";
	}
	
	/**
	 * 
	* @author jlh
	* @param staff
	* @param session
	* @return
	* @return Result
	* @time 2018 下午8:06:49
	* @desc	增加或者修改员工信息
	*
	 */
	@RequestMapping("/addOrUpdateStaff")
	@ResponseBody
	public Result addOrUpdateStaff(Staff staff,HttpSession session) {
		StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
		if (staff != null && staff.getStaffId() != 0) {
			//当员工Id不为空为修改
			staff.setOperationPerson(staffLoginVo.getStaffId());
			staffBiz.updateStaffUserName(staff);
			return ResultUtil.success(Constant.STATE1, Constant.UPDATE_SUCCESS);
		}
		staff.setOperationPerson(staffLoginVo.getStaffId());
		staffBiz.addStaff(staff);
		return ResultUtil.success(Constant.STATE1, Constant.ADD_SUCCESS);
	}
}
