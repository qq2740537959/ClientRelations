package com.znsd.client.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.znsd.client.service.ClientService;

@SuppressWarnings("serial")
@Namespace("/")
@ParentPackage("json-default")
public class ClientResourceOperateAction extends ActionSupport {
	
	private String conditionName;	//条件名   clientName 或  phone
	private Integer allotState;		//分配状态
	private String  condition;		//查询条件
	
	private Integer page;
	private Integer limit;
	
	private Map<String, Object> map = new HashMap<String, Object>();	//返回数据
	
	@Autowired
	private ClientService service;
	
	@Action(value="selectAllClient", results = {@Result(name=ActionSupport.SUCCESS,type="json",params= {"root","map"})})
	public String selectAllClient() {
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
		map.put("code", 0);
		map.put("data", list);
		map.put("page", page);
		map.put("limit", limit);
		map.put("count", pages.getTotal());
		return SUCCESS;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getAllotState() {
		return allotState;
	}

	public void setAllotState(Integer allotState) {
		this.allotState = allotState;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
}
