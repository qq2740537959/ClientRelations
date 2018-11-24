package com.znsd.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.Hap;
import com.znsd.client.service.ClientService;
import com.znsd.client.service.HapService;

@Controller
public class HapAction {
	@Autowired
	private ClientService clientBiz;
	@Autowired
	private HapService hapBiz;
	private Map<String,Object> map = new HashMap();//用于接东西
	//分页机会selectHapPage
	@RequestMapping("selectHapPage")
	@ResponseBody
	public Map<String,Object> selectHapPage(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,@RequestParam(name="name",required=false) String name) {
		Page<Object> pages = PageHelper.startPage(page, limit);
		map.put("data",hapBiz.selectHapByPage(name));
		map.put("code",0);
		map.put("count",pages.getTotal());
		return map;
	}
	//根据id查询机会
	@RequestMapping("getHapData")
	@ResponseBody
	public Map<String,Object> getHapData(@RequestParam(name="chanceId",required=false) Integer chanceId) {
		map.put("data",hapBiz.getHapData(chanceId));
		map.put("code",0);
		return map;
	}
	@RequestMapping("updateHap")
	@ResponseBody
	public Map<String,Object> updateHap(Hap hap) {
		hap.setHandleId(1);
		hap.setLastTime(new Date());
		hapBiz.updateHap(hap);
		map.put("msg","修改成功");
		map.put("code",0);
		return map;
	}
	
	@RequestMapping("getClientData")
	@ResponseBody
	public Map<String,Object> getClientData(){
		
		return map;
	}
}	 