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
import com.github.pagehelper.PageHelper;
import com.znsd.client.service.ClientWorthService;

@Controller
public class ClientWorthController {
	
	@Autowired
	private ClientWorthService service;
	
	@RequestMapping("/queryWorth")
	@ResponseBody
	public Map<String, Object> selectClientWorth(@RequestParam(value="clientName",required=false)String clientName, @RequestParam("page") Integer page, @RequestParam("limit")Integer limit, Map<String, Object> model){
		
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Map<String, Object>> list = service.selectClientWorthByPage(clientName);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		model = new HashMap<String, Object>();
		model.put("code", 0);
		model.put("data", list);
		model.put("page", page);
		model.put("limit", limit);
		model.put("count", pages.getTotal());
		return model;
	}
	
}
