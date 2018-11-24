
    /**  
    * @Title: IssueDao.java
    * @Package com.znsd.client.dao
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年11月13日
    * @version V1.0  
    */
    
package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Issue;

/**
    * @ClassName: IssueDao
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月13日
    *
    */
@Repository
public interface IssueDao {

	
	    /**
	    * @Title: issuequery
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
