package com.znsd.client.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.znsd.client.bean.Contract;
import com.znsd.client.bean.Genre;
import com.znsd.client.bean.Shape;
import com.znsd.client.bean.Staff;
import com.znsd.client.bean.TopTree;
import com.znsd.client.service.ContractService;
import com.znsd.client.service.TopTreeService;
import com.znsd.client.vo.StaffLoginVo;
import com.znsd.client.vo.StaffVo;

@Controller
public class ContractAction{
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private TopTreeService topTreeService;
	
	@ResponseBody
	@RequestMapping(value = "/fortifyAction")
	public Map<String,Object> fortifyAction(Contract con,@RequestParam(value = "list",required=false) List<Contract> list,@RequestParam(value = "msg",required = false) String msg,Map<String,Object> map,HttpServletRequest request) {
		 	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 	String dateString = formatter.format(new Date());
		 	
			list = new ArrayList<Contract>();
			list.add(con);
			con.setLastTime(dateString);
			con.setContractState(1);
			con.setStaffId(getUser(request).getStaffId());
			con.setEstablish(getUser(request).getStaffName());
			int addContract = contractService.addContract(list);
			if(addContract > 0) {
				msg = "增加成功！";
			}else {
				msg = "增加失败！";
			}
			map = new HashMap<String, Object>();
			map.put("code", addContract);
			map.put("msg", msg);
			return map;
	}
	
	@ResponseBody
	@RequestMapping("/demandAction")
	public Map<String,Object> demandAction(@RequestParam(value = "page",required=false) Integer page,@RequestParam(value = "limit",required = false) Integer limit,@RequestParam(value = "contractName",required = false) String contractName,
			@RequestParam(value = "contractState",required = false) String contractState,@RequestParam(value = "contractType",required = false) String contractType,Map<String,Object> map) {
		if(page == 0) {
			page = 1;
		}
		if(limit == 0) {
			limit = 5;
		}
		if(contractName == null) {
			contractName = ""; 
		}
		if(contractState == null) {
			contractState = "";
		}
		if(contractType == null) {
			contractType = "";
		}
		Page<Object> pages = PageHelper.startPage(page,limit);
		map = new HashMap<String, Object>();
		map.put("data", contractService.selectContractByPage(contractName, contractState, contractType));
		map.put("code", 0);
		map.put("count", pages.getTotal());
		return map;
	} 
	
	@ResponseBody
	@RequestMapping(value = "/examineAction")
	public List<Contract> examineAction(@RequestParam(value = "contractId",required = false) int contractId) {
		List<Contract> selectDetails = contractService.selectDetails(contractId);
		return selectDetails;
	}
	
	@ResponseBody
	@RequestMapping(value = "/patternAction")
	public List<Shape> patternAction() {
		List<Shape> selectShape = contractService.selectShape();
		return selectShape;
	}
	
	@ResponseBody
	@RequestMapping(value = "/voiceAction")
	public List<Genre> voiceAction() {
		List<Genre> selectGenre = contractService.selectGenre();
		return selectGenre;
	}
	
	@ResponseBody
	@RequestMapping(value = "/transformAction")
	public Map<String,Object> transformAction(Contract con,@RequestParam(value = "msg",required = false) String msg,Map<String,Object> map) {
			int updateContract = contractService.updateContract(con);
			if(updateContract > 0) {
				msg = "修改成功！";
			}else {
				msg = "修改失败！";
			}
			map = new HashMap<String, Object>();
			map.put ("code", updateContract);
			map.put("msg", msg);
			return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delegateAction")
	public Map<String,Object> delegateAction(Map<String,Object> map,HttpServletRequest request,@RequestParam(value = "msg",required = false) String msg){
		int a = getUser(request).getStaffId();
		if(a == 1) {
			msg = "合同创建";
		}else {
			msg = "合同只能由销售代表创建！";
		}
		map = new HashMap<String,Object>();
		map.put("msg", msg);
		map.put("a", a);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/presentAction")
	public List<Staff> presentAction(){
		List<Staff> selectStaff = contractService.selectStaff();
		return selectStaff;
	}
	
	@ResponseBody
	@RequestMapping(value = "/singnAction")
	public List<StaffVo> singnAction(@RequestParam(value = "contractId",required = false) int contractId){
		List<StaffVo> selectEingereicht = contractService.selectEingereicht(contractId);
		return selectEingereicht;
	}
	
	@ResponseBody
	@RequestMapping(value = "/someBodyAction")
	public Map<String,Object> someBodyAction(Contract cons,@RequestParam(value = "msg",required = false) String msg,Map<String,Object> map,HttpServletRequest request){
		cons.setContractState(2);
		int updateSubmit = contractService.updateSubmit(cons);
		if(updateSubmit > 0) {
			msg = "合同提交成功！";
		}else {
			msg = "合同提交失败！";
		}
		map = new HashMap<String, Object>();
		map.put("code", updateSubmit);
		map.put("msg", msg);
		return map;
	} 
	
	@ResponseBody
	@RequestMapping(value = "/authorityAction")
	public List<Contract> authorityAction(@RequestParam(value = "contractId",required = false) int contractId){
		List<Contract> selectCredit = contractService.selectCredit(contractId); 
		return selectCredit;
	}
	
	@ResponseBody
	@RequestMapping(value = "/processAction")
	public Map<String,Object> processAction (Contract con,@RequestParam(value = "msg",required = false)String msg,Map<String,Object> map){
		con.setContractState(3);
		int updateExamine = contractService.updateExamine(con);
		if(updateExamine >0) {
			msg = "合同审核成功！";
		}else {
			msg = "合同审核失败！";
		}
		map = new HashMap<String,Object>();
		map.put("code", updateExamine);
		map.put("msg", msg);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/waittingAction")
	public Map<String,Object> waittingAction (Contract con,@RequestParam(value = "msg",required = false)String msg,Map<String,Object> map){
		con.setContractState(4);
		int updateExamine = contractService.updateExamine(con);
		if(updateExamine >0) {
			msg = "合同审核成功！";
		}else {
			msg = "合同审核失败！";
		}
		map = new HashMap<String,Object>();
		map.put("code", updateExamine);
		map.put("msg", msg);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/executiveAction")
	public Map<String,Object> executiveAction(Contract con,@RequestParam(value = "msg",required = false)String msg,Map<String,Object> map){
		con.setContractState(5);
		int updatePower = contractService.updatePower(con);
		if(updatePower > 0) {
			msg = "合同执行成功！";
		}else {
			msg = "合同执行失败！";
		}
		map = new HashMap<String,Object>();
		map.put("code", updatePower);
		map.put("msg", msg);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/trainAction")
	public Map<String,Object> trainAction(Contract con,@RequestParam(value = "msg",required = false)String msg,Map<String,Object> map){
		con.setContractState(7);
		int updatePolicy = contractService.updatePolicy(con);
		if(updatePolicy > 0) {
			msg = "合同变更成功！";
		}else {
			msg = "合同变更失败！";
		}
		map = new HashMap<String,Object>();
		map.put("code", updatePolicy);
		map.put("msg", msg);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/cancelAction")
	public Map<String,Object> cancelAction(Contract con,@RequestParam(value = "msg",required = false)String msg,Map<String,Object> map){
		con.setContractState(8);
		int updateDispel = contractService.updateDispel(con);
		if(updateDispel>0) {
			msg = "合同解除成功！";
		}else {
			msg = "合同解除失败！";
		}
		map = new HashMap<String,Object>();
		map.put("code", updateDispel);
		map.put("msg", msg);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/beachAction")
	public Map<String,Object> beachAction(Contract con,@RequestParam(value = "msg",required = false)String msg,Map<String,Object> map,HttpServletRequest request){
		con.setContractState(1);
		int updateRepulse = contractService.updateRepulse(con);
		if(updateRepulse >0) {
			msg = "打回成功！";
		}else {
			msg = "打回失败！";
		}
		map = new HashMap<String,Object>();
		map.put("code", updateRepulse);
		map.put("msg", msg);
		return map;
	}
	
	public StaffLoginVo getUser(HttpServletRequest request) {
		return (StaffLoginVo)request.getSession().getAttribute("userInfo");
	}
	
	@ResponseBody
	@RequestMapping(value = "/princeAction")
	public List<Contract> princeAction(){
		List<Contract> Institution = contractService.Institution();
		return Institution;
	}
	
	@ResponseBody
	@RequestMapping(value = "/proviceAction")
	public List<TopTree> proviceAction(){
		List<TopTree> selectToptreeAll = topTreeService.selectToptreeAll();
		return selectToptreeAll;
	}
	
}
