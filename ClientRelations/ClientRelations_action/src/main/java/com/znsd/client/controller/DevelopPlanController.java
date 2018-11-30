package com.znsd.client.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.DevelopPlan;
import com.znsd.client.service.DevelopPlanService;
import com.znsd.client.vo.StaffLoginVo;

@Controller
public class DevelopPlanController {
	
	@Autowired
	private DevelopPlanService service;
	
	Map<String, Object> model = new HashMap<String, Object>();
	
	@RequestMapping("/selectDevelopPlan")
	@ResponseBody
	public Map<String, Object> selectDevelopPlan(@RequestParam(value="month",required=false)String month, @RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		System.out.println(page+"--------------"+limit);
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<DevelopPlan> list =service.selectDevelopPlan(month);
		model.put("code", 0);
		model.put("data", list);
		model.put("page", page);
		model.put("limit", limit);
		model.put("count", pages.getTotal());
		return model;
	}

	@RequestMapping("/deletePlan")
	@ResponseBody
	public Map<String, Object> deleteDevelopPlan(@RequestParam("planId")Integer planId){
		String msg = "";
		Integer count = service.deleteDevelopPlan(planId);
		if (count > 0) {
			msg = "删除成功";
		}else {
			msg = "删除失败";
		}
		
		model.put("msg", msg);
		return model;
	}
	
	@RequestMapping("/insertDevelopPlan")
	@ResponseBody
	public Map<String, Object> addDevelopPlan(DevelopPlan plan,HttpServletRequest request){
		plan.setStaffId(getUser(request).getStaffId());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String foundTime = formatter.format(new Date());
		plan.setFoundTime(foundTime);
		String msg = "";
		Integer count = service.insertDevelopPlan(plan);
		if (count > 0) {
			msg = "增加成功";
		}else {
			msg = "增加失败";
		}
		model.put("msg", msg);
		return model;
	}
	
	@RequestMapping("/updateDevelopPlan")
	@ResponseBody
	public Map<String, Object> updateDevelopPlan(DevelopPlan plan,HttpServletRequest request){
		plan.setStaffId(getUser(request).getStaffId());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String lastOpterateTime = formatter.format(new Date());
		plan.setLastOpterateTime(lastOpterateTime);
		String msg = "";
		Integer count = service.updateDevelopPlan(plan);
		if (count > 0) {
			msg = "修改成功";
		}else {
			msg = "修改失败";
		}
		model.put("msg", msg);
		return model;
	}
	
	@RequestMapping("/selectClientIdName")
	@ResponseBody
	public Map<String, Object> selectClientIdName(){
		List<Map<String, Object>> list = service.selectClientName();
		model.put("data", list);
		return model;
	}
	
	@RequestMapping("/selectPlanNameInfo")
	@ResponseBody
	public Map<String, Object> selectPlanInClientName(){
		List<Map<String, Object>> list = service.selectPlanInClientName();
		model.put("data", list);
		return model;
	}
	
	public StaffLoginVo getUser(HttpServletRequest request) {
		return (StaffLoginVo)request.getSession().getAttribute("userInfo");
	}
	
	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
}
