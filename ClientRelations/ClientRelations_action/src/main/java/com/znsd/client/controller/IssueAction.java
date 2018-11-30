
    /**  
    * @Title: IssueAction.java
    * @Package com.znsd.client.action
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年11月13日
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
import com.znsd.client.bean.Issue;
import com.znsd.client.service.IssueService;

/**
    * @ClassName: IssueAction
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月13日
    *
    */
@Controller
public class IssueAction{

	
	    /**
	    * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	    */
	    
	@Autowired
	private IssueService issueService;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	@RequestMapping("/issueQuery")
	@ResponseBody
	public Map<String,Object> issueQuery(@RequestParam("page") int page,@RequestParam("limit")int limit,Map<String,Object> map){
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Issue> list = issueService.issueQuery();
		map = new HashMap<String,Object>();
		map.put("data",list);
		map.put("count",pages.getTotal());
		map.put("code",0);
		return map;
	}
	
	@RequestMapping("/issuesAdd")
	@ResponseBody
	public Map<String,Object> issuesAdd(Issue issue){
		System.out.println(".............issueAdd========="+issue);
		issue.setCreateBy("admin");
		issue.setUpdateBy("admin");
		issueService.issueAdd(issue);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/issuesDelete")
	@ResponseBody
	public Map<String,Object> issuesDelete(@RequestParam("id")int id){
		System.out.println("............id=="+id);
		Issue issue = new Issue();
		issue.setId(id);
		issueService.issueDelete(issue);
		map.put("code", 1);
		return map;
	}
	
	@RequestMapping("/issuesUpdate")
	@ResponseBody
	public Map<String,Object> issuesUpdate(Issue issue){
		issue.setUpdateBy("admin");
		issueService.issueUpdate(issue);
		map.put("code", 1);
		return map;
	}
	
	public IssueService getIssueService() {
		return issueService;
	}



	public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}	
	
}
