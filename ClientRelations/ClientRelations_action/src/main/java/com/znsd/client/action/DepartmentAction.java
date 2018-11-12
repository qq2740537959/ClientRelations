package com.znsd.client.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@ParentPackage("json-default")
public class DepartmentAction extends ActionSupport implements SessionAware,RequestAware{

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


	@Action(value="queryDepartmentByPage",results= {
			@Result(name=ActionSupport.SUCCESS,type="json",params= {"root","departmentData"})
	})
	public String queryDepartmentByPage() {
		System.out.println("page"+page+"------"+"limit"+limit);
		
		return SUCCESS;
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
