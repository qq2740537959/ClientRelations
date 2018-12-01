
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

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.Serve;
import com.znsd.client.service.ServeService;
import com.znsd.client.vo.StaffLoginVo;
import com.znsd.client.vo.StaffVo;

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
	public Map<String,Object> serveQuery(@RequestParam("page")int page,@RequestParam("limit")int limit,Map<String,Object> map,Serve serve){
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Serve> list = serveService.serveQuery(serve);
		map = new HashMap<String, Object>();
		map.put("data",list);
		map.put("count",pages.getTotal());
		map.put("code",0);
		return map;
	}
	
	@RequestMapping("/serveStateQuery")
	@ResponseBody
	public Map<String,Object> serveStateQuery(@RequestParam("page")int page,@RequestParam("limit")int limit,String state,Map<String,Object> map,Serve serve){
		serve.setServeState(state);
		Page<Object> pages = PageHelper.startPage(page,limit);
		List<Serve> list = serveService.serveStateQuery(serve);
		map = new HashMap<String, Object>();
		map.put("data",list);
		map.put("count",pages.getTotal());
		map.put("code",0);
		return map;
	}
	
	@RequestMapping("/serveAdd")
	@ResponseBody
	public Map<String,Object> serveAdd(Serve serve,HttpServletRequest request){
		serve.setServeState("新创建");
		serve.setOperator(getUser(request).getStaffName());
		serve.setPendingPeople(getUser(request).getStaffName());
		serve.setCreateBy(getUser(request).getStaffName());
		serve.setUpdateBy(getUser(request).getStaffName());
		serveService.serveAdd(serve);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/serveDelete")
	@ResponseBody
	public Map<String,Object> serveDelete(@RequestParam("id")int id,HttpServletRequest request){
		Serve serve = new Serve();
		serve.setId(id);
		serve.setOperator(getUser(request).getStaffName());
		serveService.serveDelete(serve);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/serveSub")
	@ResponseBody
	public Map<String,Object> serveSub(@RequestParam("id")int id,HttpServletRequest request){
		Serve serve = new Serve();
		serve.setId(id);
		serve.setOperator(getUser(request).getStaffName());
		serveService.serveSub(serve);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/serveUpdate")
	@ResponseBody
	public Map<String,Object> serveUpdate(Serve serve,HttpServletRequest request){
		serve.setOperator(getUser(request).getStaffName());
		serve.setUpdateBy(getUser(request).getStaffName());
		serveService.serveUpdate(serve);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/servePigeonhole")
	@ResponseBody
	public Map<String,Object> servePigeonhole(@RequestParam("id")int id,HttpServletRequest request){
		Serve serve = new Serve();
		serve.setId(id);
		serve.setOperator(getUser(request).getStaffName());
		serveService.servePigeonhole(serve);
		map.put("code", 1);
		return map;
	}
	
	
	@RequestMapping("/serveDispose")
	@ResponseBody
	public Map<String,Object> serveDispose(Serve serve,HttpServletRequest request){
		int retuntState = 1;
		serve.setOperator(getUser(request).getStaffName());
		if(serve.getServeState().equals("已提交")){
			retuntState = 0;
		}else if(serve.getServeState().equals("未反馈")){
			retuntState = 0;
			map.put("code", retuntState);
			return map;
		}
		serveService.serveDispose(serve);
		map.put("code", retuntState);
		return map;
	}
	
	@RequestMapping("/serveAllocation")
	@ResponseBody
	public Map<String,Object> serveAllocation(Serve serve,HttpServletRequest request){
		serve.setOperator(getUser(request).getStaffName());
		serve.setServeState("已分配");
		serveService.serveAllocation(serve);
		map.put("code", 1);
		return map;
	}
	
	
	public StaffLoginVo getUser(HttpServletRequest request){
		StaffLoginVo staff = (StaffLoginVo) request.getSession().getAttribute("userInfo");
		return staff;
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
