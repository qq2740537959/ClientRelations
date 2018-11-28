package com.znsd.client.controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.ClientResource;
import com.znsd.client.service.ClientService;

@Controller
public class ClientResourceOperateAction {
	
	@Autowired
	private ClientService service;
	
/*	@Action(value="selectAllClient", results = {@Result(name=ActionSupport.SUCCESS,type="json",params= {"root","map"})})*/
	@RequestMapping("/selectAllClient")
	@ResponseBody
	public Map<String, Object> selectAllClient(@RequestParam(value="allotState",required=false) Integer allotState,@RequestParam(value="conditionName",required=false)String conditionName,
			@RequestParam(value="condition",required=false)String condition,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,Map<String, Object> model) {
		Page<Object> pages = PageHelper.startPage(page, limit);		//分页
		List<Map<String, Object>> list = service.selectAllClientByPage(allotState,conditionName,condition);
		for (Map<String, Object> map : list) {
			map.put("clientType", map.get("clientType")+"客户");
			
			// 分配状态改成文字状态显示
			if ("1" .equals(String.valueOf(map.get("allotState")))) {
				map.put("allotState", "未分配");
			}else if ("2" .equals(String.valueOf(map.get("allotState")))) {
				map.put("allotState", "已分配");
			}
			// 状态改成文字状态显示
			if ("1" .equals(String.valueOf(map.get("state")))) {
				map.put("state", "正常");
			}else if ("2" .equals(String.valueOf(map.get("state")))) {
				map.put("state", "被禁用");
			}else if ("3" .equals(String.valueOf(map.get("state")))) {
				map.put("state", "已流失");
			}
		}
		model = new HashMap<String, Object>();
		model.put("code", 0);
		model.put("data", list); 
		model.put("page", page);
		model.put("limit", limit);
		model.put("count", pages.getTotal());
		
		return model;
	}
	
	@RequestMapping("/addResource")
	@ResponseBody
	public Map<String, Object> addResource(ClientResource resource,Map<String, Object> model){
		StringBuffer msg ;
		resource.setConsumptionTimes(0);
		resource.setTotalConsumptionAmount(0.0);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(new Date());
		resource.setInTime(dateString);
		Integer ccc = service.addResource(resource);
		if (ccc > 0) {
			msg = new StringBuffer("增加成功");
		}else {
			msg = new StringBuffer("增加失败");
		}
		model = new HashMap<String, Object>();
		model.put("msg", msg);
		return model;
	}
	
	@RequestMapping("/updateResource")
	@ResponseBody
	public Map<String, Object> updateResource(ClientResource resource,Map<String, Object> model){
		StringBuffer msg ;
		System.out.println(resource.toString());
		Integer ccc = service.updateResource(resource);
		if (ccc > 0) {
			msg = new StringBuffer("修改成功");
		}else {
			msg = new StringBuffer("修改失败");
		}
		model = new HashMap<String, Object>();
		model.put("msg", msg);
		return model;
	}
	
	@RequestMapping("/updateStaffId")
	@ResponseBody
	public Map<String, Object> updateStaffId(@RequestParam("staffId") Integer staffId, @RequestParam("clientId") Integer clientId,Map<String, Object> model){
		String msg;
		Integer count = service.updateStaffId(staffId, clientId);
		if (count > 0) {
			msg = "分配成功";
		}else {
			msg = "分配失败";
		}
		model = new HashMap<String, Object>();
		model.put("msg", msg);
		return model;
	}
	
	/*@RequestMapping("/updasteChanceId")
	public Map<String, Object> updateChanceId(@RequestParam("staffId") Integer staffId, @RequestParam("clientId") Integer clientId, Map<String, Object> model){
		
		return model;
	}*/
	
 }
