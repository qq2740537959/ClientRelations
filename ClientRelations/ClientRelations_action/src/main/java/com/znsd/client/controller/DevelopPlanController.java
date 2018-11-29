package com.znsd.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.DevelopPlan;
import com.znsd.client.service.DevelopPlanService;

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
		for (DevelopPlan developPlan : list) {
			System.out.println(developPlan);
		}
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
	public Map<String, Object> addDevelopPlan(DevelopPlan plan){
		
		return model;
	}
	
	@RequestMapping("/updateDevelopPlan")
	@ResponseBody
	public Map<String, Object> updateDevelopPlan(DevelopPlan plan){
		
		return model;
	}
	
	@RequestMapping("/selectClientIdName")
	@ResponseBody
	public Map<String, Object> selectClientIdName(){
		List<Map<String, Object>> list = service.selectClientName();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		model.put("data", list);
		return model;
	}
	
	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
}
