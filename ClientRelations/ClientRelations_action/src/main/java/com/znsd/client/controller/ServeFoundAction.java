
    /**  
    * @Title: ServeFoundAction.java
    * @Package com.znsd.client.action
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年11月12日
    * @version V1.0  
    */
    
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
import com.znsd.client.bean.Serve;
import com.znsd.client.service.ServeService;

/**
    * @ClassName: ServeFoundAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月12日
    *
    */
@Controller
public class ServeFoundAction{
	    
	@Autowired
	private ServeService serveService;
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	@RequestMapping("/serveQuery")
	@ResponseBody
	public Map<String,Object> serveQuery(@RequestParam("page")int page,@RequestParam("limit")int limit,Map<String,Object> map){
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Serve> list = serveService.serveQuery();
		map = new HashMap<String, Object>();
		map.put("data",list);
		map.put("count",pages.getTotal());
		map.put("code",0);
		return map;
	}
	
	@RequestMapping("/serveStateQuery")
	@ResponseBody
	public Map<String,Object> serveStateQuery(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("state")int state,Map<String,Object> map){
		System.out.println("wwwwwwwwwwwww"+state);
		map.put("code",0);
		return map;
	}
	
	@RequestMapping("/serveAdd")
	@ResponseBody
	public Map<String,Object> serveAdd(Serve serve){
		System.out.println(serve+".......Add");
		serve.setServeState("新创建");
		serve.setOperator("admin");
		serve.setPendingPeople("销售员工");
		serve.setCreateBy("admin");
		serve.setUpdateBy("admin");
		serveService.serveAdd(serve);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/serveDelete")
	@ResponseBody
	public Map<String,Object> serveDelete(@RequestParam("id")int id){
		System.out.println(id+".......Delete");
		Serve serve = new Serve();
		serve.setId(id);
		serve.setOperator("admin");
		serveService.serveDelete(serve);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/serveSub")
	@ResponseBody
	public Map<String,Object> serveSub(@RequestParam("id")int id){
		Serve serve = new Serve();
		serve.setId(id);
		serve.setOperator("admin");
		serveService.serveSub(serve);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/serveUpdate")
	@ResponseBody
	public Map<String,Object> serveUpdate(Serve serve){
		serve.setOperator("admin");
		serve.setUpdateBy("admin");
		System.out.println("...........update===id=="+serve);
		serveService.serveUpdate(serve);
		map.put("code", 1);
		return map;
	}
	
	public ServeService getServeService() {
		return serveService;
	}
	public void setServeService(ServeService serveService) {
		this.serveService = serveService;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	

	
}
