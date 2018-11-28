package com.znsd.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.SellPlan;
import com.znsd.client.service.SellPlanService;
import com.znsd.client.vo.StaffLoginVo;

@Controller
public class SellPlanController {
	@Autowired
	private SellPlanService sellPlanBiz;
	
	private Map<String,Object> map = new HashMap<String,Object>();//用于接东西

	@RequestMapping("/selectSellPlanByPage")
	@ResponseBody
	public Map<String, Object> selectSellPlanByPage(@RequestParam(name="planMonth",required=false) String planMonth, @RequestParam("page") Integer page,@RequestParam("limit")Integer limit,HttpServletRequest request) {
		Page<Object> pages = PageHelper.startPage(page,limit);
		map.put("data",sellPlanBiz.selectSellPlanByPage(getUser(request).getUserName(),getUser(request).getStaffId(), planMonth));
		map.put("code", 0);
		map.put("count",pages.getTotal());
		return map;
	}
	
	@RequestMapping("/addSellPlan")
	@ResponseBody
	public Map<String, Object> addSellPlan(SellPlan sellPlan,HttpServletRequest request) {
		sellPlan.setSellingId(getUser(request).getStaffId());
		sellPlan.setMoney(sellPlan.getMoney()*10000);
		sellPlan.setPlanMonth(sellPlan.getPlanMonth()+"-01");
		sellPlan.setLastTime(new Date());
		sellPlanBiz.addSellPlan(sellPlan);
		map.put("msg","增加成功");
	
		return map;
	}
	
	@RequestMapping("/subSellPlan")
	@ResponseBody
	public Map<String,Object> subSellPlan(SellPlan sellPlan,HttpServletRequest request){
		sellPlanBiz.subSellPlan(getUser(request).getRoleName(),sellPlan.getPlanId());
		map.put("msg","提交成功");
		return map;
	}
	
	@RequestMapping("/delSellPlan")
	@ResponseBody
	public Map<String,Object> delSellPlan(@RequestParam("planId")Integer planId,HttpServletRequest request){
		sellPlanBiz.delSellPlan(planId);
		map.put("msg","删除成功");
		return map;
	}
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	@RequestMapping("/getUserInfos")
	@ResponseBody
	public Map<String,Object> getUserInfos(HttpServletRequest request) {
		StaffLoginVo staff =(StaffLoginVo) request.getSession().getAttribute("userInfo");
		map.put("user",staff);
		return map;
	}
	
	@RequestMapping("/examineState")
	@ResponseBody
	public Map<String,Object> examineState(SellPlan sellPlan) {
		sellPlanBiz.examineSellPlan(sellPlan);
		map.put("msg","已审核");
		return map;
	}
	
	public StaffLoginVo getUser(HttpServletRequest request) {
		StaffLoginVo staff =(StaffLoginVo) request.getSession().getAttribute("userInfo");
		return staff;
	}

	
}	 