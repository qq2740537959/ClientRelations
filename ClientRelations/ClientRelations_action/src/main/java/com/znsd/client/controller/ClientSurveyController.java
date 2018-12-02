package com.znsd.client.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.client.service.ClientSurveyService;
import com.znsd.client.vo.StaffLoginVo;

@Controller
public class ClientSurveyController {

	@Autowired
	private ClientSurveyService service;
	
	@RequestMapping("/selectClientSurvey")
	@ResponseBody
	public Map<String, Object> selectClientSurvey(@RequestParam(value="clientName",required=false)String clientName,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,HttpServletRequest request){
		return service.selectAllClientSurveyByPage(clientName, getUser(request).getRoleId(), getUser(request).getStaffId(),page,limit);
	}
	
	public StaffLoginVo getUser(HttpServletRequest request) {
		return (StaffLoginVo) request.getSession().getAttribute("userInfo");
	}
}
