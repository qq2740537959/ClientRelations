
    /**  
    * @Title: IssueServiceImpl.java
    * @Package com.znsd.client.service.impl
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年11月13日
    * @version V1.0  
    */
    
package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Issue;
import com.znsd.client.dao.IssueDao;
import com.znsd.client.service.IssueService;

/**
    * @ClassName: IssueServiceImpl
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月13日
    *
    */
@Service
public class IssueServiceImpl implements IssueService{
	@Autowired
	private IssueDao issueDao;
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @return
	    * @see com.znsd.client.service.IssueService#issueQuery()
	    */
	    
	public IssueDao getIssueDao() {
		return issueDao;
	}


	public void setIssueDao(IssueDao issueDao) {
		this.issueDao = issueDao;
	}


	@Override
	public List<Issue> issueQuery() {
		// TODO Auto-generated method stub
		return issueDao.issueQuery();
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param issue
	    * @see com.znsd.client.service.IssueService#issueAdd(com.znsd.client.bean.Issue)
	    */
	    
	@Override
	public void issueAdd(Issue issue) {
		// TODO Auto-generated method stub
		issueDao.issueAdd(issue);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param id
	    * @see com.znsd.client.service.IssueService#issueDelete(int)
	    */
	    
	@Override
	public void issueDelete(Issue issue) {
		// TODO Auto-generated method stub
		issueDao.issueDelete(issue);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param issue
	    * @see com.znsd.client.service.IssueService#issueUpdate(com.znsd.client.bean.Issue)
	    */
	    
	@Override
	public void issueUpdate(Issue issue) {
		// TODO Auto-generated method stub
		issueDao.issueUpdate(issue);
	}

}
