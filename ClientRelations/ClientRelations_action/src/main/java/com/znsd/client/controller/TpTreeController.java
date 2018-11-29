package com.znsd.client.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.znsd.client.bean.TopTree;
import com.znsd.client.service.TopTreeService;

@Controller
@RequestMapping("/")
public class TpTreeController{
	@Autowired
	private TopTreeService topService;
	
	@RequestMapping("/selectTpTreeAll")
	public @ResponseBody List<TopTree> selectTpTreeAll() {
		//查询省份 
		System.out.println("简监督科；skdfl");
		List<TopTree> topTree = topService.selectToptreeAll(); 
		return topTree;
	}
	@RequestMapping("/selectTpTreeById")
	public @ResponseBody List<TopTree> selectTpTreeById(@RequestParam("id") Integer id) {
		//查询市、区
		List<TopTree> topTree = topService.selectToptreeByPId(id);
		return topTree;
	}
	@RequestMapping("/selectTpById")
	public @ResponseBody List<TopTree> selectTopeById(@RequestParam(value="city",required=false) String city) {
		//查询省、市、区
		String [] ary = city.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ary.length; i++) {
			list.add(Integer.valueOf(ary[i]));
		}
		List<TopTree> topTree = topService.selectTopeByPId(list);
		return topTree;
	}
	
}
