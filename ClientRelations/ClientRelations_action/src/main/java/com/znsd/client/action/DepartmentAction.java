package com.znsd.client.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentAction {

	private Map<String, Object> session;
	private Map<String, Object> request;
	private Map<String, Object> departmentData = new HashMap<String, Object>();
	private int page;
	private int limit;
	
	public Map<String, Object> getDepartmentData() {
		return departmentData;
	}

	public void setDepartmentData(Map<String, Object> departmentData) {
		this.departmentData = departmentData;
	}


/*	@Action(value="queryDepartmentByPage",results= {
			@Result(name=ActionSupport.SUCCESS,type="json",params= {"root","departmentData"})
	})*/
	@RequestMapping("/queryDepartmentByPage")
	public String queryDepartmentByPage() {
		System.out.println("page"+page+"------"+"limit"+limit);
		
		return "";
	}
	
	
	
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
