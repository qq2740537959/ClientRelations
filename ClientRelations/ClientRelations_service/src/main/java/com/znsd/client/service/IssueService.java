
    /**  
    * @Title: IssueService.java
    * @Package com.znsd.client.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年11月13日
    * @version V1.0  
    */
    
package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.Issue;

/**
    * @ClassName: IssueService
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月13日
    *
    */

public interface IssueService {

		
		    /**
		    * @Title: issueQuery
		    * @Description: TODO(这里用一句话描述这个方法的作用)
		    * @param @return    参数
		    * @return List<Issue>    返回类型
		    * @throws
		    */
		    
		List<Issue> issueQuery();

			
			    /**
			    * @Title: issueAdd
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param @param issue    参数
			    * @return void    返回类型
			    * @throws
			    */
			    
			void issueAdd(Issue issue);
	
}
