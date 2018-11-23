package com.znsd.client.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
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
		System.out.println(page+"-----------"+limit);
		Page<Object> pages = new Page<Object>(page, limit);		//分页
		List<Map<String, Object>> list = service.selectAllClientByPage();
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
		model.put("count", (pages.getTotal()+1));
		
		System.out.println("action controller=="+model);
		return model;
	}
}
