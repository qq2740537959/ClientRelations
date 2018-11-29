package com.znsd.client.controller;

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
import com.znsd.client.bean.Hap;
import com.znsd.client.service.ClientService;
import com.znsd.client.service.HapService;
import com.znsd.client.service.StaffService;
import com.znsd.client.vo.StaffLoginVo;

@Controller
public class HapController {
	@Autowired
	private ClientService clientBiz;
	@Autowired
	private HapService hapBiz;
	@Autowired
	private StaffService staffBiz;
	
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
	public Map<String,Object> updateHap(Hap hap,HttpServletRequest request) {
		hap.setHandleId(getUser(request).getStaffId());
		hap.setLastTime(new Date());
		hapBiz.updateHap(hap);
		map.put("msg","修改成功");
		map.put("code",0);
		return map;
	}
	
	@RequestMapping("getClientData")
	@ResponseBody
	public Map<String,Object> getClientData(){
		List<Map<String, Object>> list = clientBiz.selectResourceState();
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("updateAllotHap")
	@ResponseBody
	public Map<String,Object> updateAllotHap(@RequestParam("staffId") Integer staffId,@RequestParam("chanceId") Integer chanceId,HttpServletRequest request){
		hapBiz.updateAllotHap(staffId,getUser(request).getStaffId(),chanceId);
		clientBiz.updateStaffId(staffId, chanceId);
		map.put("msg","分配成功");
		
		return map;
	}
	
	@RequestMapping("addHapData")
	@ResponseBody
	public Map<String,Object> addHapData(Hap hap,HttpServletRequest request){
		hap.setHandleId(getUser(request).getStaffId());
		hap.setEntryTime(new Date());
		hap.setLastTime(new Date());
		Integer chanceId = hapBiz.addHap(hap);
		if (chanceId == 0) {
			map.put("msg","网络异常");
		}else {
			clientBiz.updateChanceId(hap.getClientId(), hap.getChanceId());
			map.put("msg","增加成功");
		}
		
		
		return map;
	}
	@RequestMapping("getStaffDeputyData")
	@ResponseBody
	public Map<String,Object> getStaffDeputyData(){
		map.put("data",staffBiz.getStaffDeputyData());
		return map;
	}
	
	public StaffLoginVo getUser(HttpServletRequest request) {
		return (StaffLoginVo) request.getSession().getAttribute("userInfo");
	}

}	 