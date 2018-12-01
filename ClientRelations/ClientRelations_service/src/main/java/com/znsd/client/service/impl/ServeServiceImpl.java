
    /**  
    * @Title: ServeServiceImpl.java
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

import com.znsd.client.bean.Serve;
import com.znsd.client.dao.ServeDao;
import com.znsd.client.service.ServeService;

/**
    * @ClassName: ServeServiceImpl
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月13日
    *
    */
@Service
public class ServeServiceImpl implements ServeService{
	@Autowired
	private ServeDao serveDao;
	public ServeDao getServeDao() {
		return serveDao;
	}


	public void setServeDao(ServeDao serveDao) {
		this.serveDao = serveDao;
	}
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @return
	    * @see com.znsd.client.service.ServeService#serveQuery()
	    */
	    
	


	@Override
	public List<Serve> serveQuery(Serve serve) {
		return serveDao.serveQuery(serve);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param serve
	    * @see com.znsd.client.service.ServeService#serveAdd(com.znsd.client.bean.Serve)
	    */
	    
	@Override
	public void serveAdd(Serve serve) {
		// TODO Auto-generated method stub
		serveDao.serveAdd(serve);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param id
	    * @see com.znsd.client.service.ServeService#serveDelete(int)
	    */
	    
	@Override
	public void serveDelete(Serve serve) {
		// TODO Auto-generated method stub
		serveDao.serveDelete(serve);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param id
	    * @see com.znsd.client.service.ServeService#serveSub(int)
	    */
	    
	@Override
	public void serveSub(Serve serve) {
		// TODO Auto-generated method stub
		serveDao.serveSub(serve);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param serve
	    * @see com.znsd.client.service.ServeService#serveUpdate(com.znsd.client.bean.Serve)
	    */
	    
	@Override
	public void serveUpdate(Serve serve) {
		// TODO Auto-generated method stub
		serveDao.serveUpdate(serve);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param serve
	    * @see com.znsd.client.service.ServeService#servePigeonhole(com.znsd.client.bean.Serve)
	    */
	    
	@Override
	public void servePigeonhole(Serve serve) {
		// TODO Auto-generated method stub
		serveDao.servePigeonhole(serve);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param serve
	    * @see com.znsd.client.service.ServeService#serveDispose(com.znsd.client.bean.Serve)
	    */
	    
	@Override
	public void serveDispose(Serve serve) {
		// TODO Auto-generated method stub
		serveDao.serveDispose(serve);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param serve
	    * @return
	    * @see com.znsd.client.service.ServeService#serveStateQuery(com.znsd.client.bean.Serve)
	    */
	    
	@Override
	public List<Serve> serveStateQuery(Serve serve) {
		// TODO Auto-generated method stub
		return serveDao.serveStateQuery(serve);
	}


	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param serve
	    * @see com.znsd.client.service.ServeService#serveAllocation(com.znsd.client.bean.Serve)
	    */
	    
	@Override
	public void serveAllocation(Serve serve) {
		// TODO Auto-generated method stub
		serveDao.serveAllocation(serve);
	}



}
