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
import com.znsd.client.bean.Statistic;
import com.znsd.client.service.StatisticService;

@Controller
public class StatisticController {

	@Autowired
	private StatisticService statisticService;

	@RequestMapping(value="/selectConstitute")
	public @ResponseBody Map<String,Object> selectConstitute(@RequestParam(value="startTime",required=false) String startTime,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit) {
		Map<String,Object> map = new HashMap();
		if(page==null) {
			page=1;
		}
		if(limit==null) {
			limit=5;
		}
		if(startTime==null || startTime=="") {
			startTime="";
		}
		System.out.println("startTime=="+startTime);
		System.out.println("page=="+page);
		System.out.println("limit=="+limit);
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Statistic>list=statisticService.constituteListByPage(startTime);
		for (Statistic statistic : list) {
			System.out.println(statistic);
		}
		map.put("data",list);
		map.put("code",0);
		map.put("count",pages.getTotal());
		return map;
	}
	
	@RequestMapping(value="/selectbution")
	public @ResponseBody Map<String,Object>selectbution(@RequestParam(value="startTime",required=false) String startTime,@RequestParam(value="endTime",required=false)String endTime,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		Map<String,Object>map=new HashMap();
		if(page==null) {
			page=1;
		}
		if(limit==null) {
			limit=5;
		}
		if(startTime==null || startTime=="") {
			startTime="";
		}
		if(endTime==null || endTime=="") {
			endTime="";
		}
		System.out.println("startTime=="+startTime);
		System.out.println("endTime=="+endTime);
		System.out.println("page=="+page);
		System.out.println("limit=="+limit);
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Statistic>list=statisticService.contributionListByPage(startTime, endTime);
		for (Statistic statistic : list) {
			System.out.println(statistic);
		}
		map.put("data",list);
		map.put("code",0);
		map.put("count",pages.getTotal());
		return map;
	}
	
	@RequestMapping(value="/selectService")
	public @ResponseBody Map<String,Object>selectService(@RequestParam(value="startTime",required=false) String startTime,@RequestParam(value="endTime",required=false)String endTime,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		Map<String,Object>map=new HashMap();
		if(page==null) {
			page=1;
		}
		if(limit==null) {
			limit=5;
		}
		if(startTime==null || startTime=="") {
			startTime="";
		}
		if(endTime==null || endTime=="") {
			endTime="";
		}
		System.out.println("startTime=="+startTime);
		System.out.println("endTime=="+endTime);
		System.out.println("page=="+page);
		System.out.println("limit=="+limit);
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Statistic>list=statisticService.serviceListByPage(startTime, endTime);
		for (Statistic statistic : list) {
			System.out.println(statistic);
		}
		map.put("data",list);
		map.put("code",0);
		map.put("count",pages.getTotal());
		return map;
	}
}
