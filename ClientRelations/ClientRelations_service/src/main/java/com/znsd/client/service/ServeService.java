
    /**  
    * @Title: ServeService.java
    * @Package com.znsd.client.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年11月13日
    * @version V1.0  
    */
    
package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.Serve;

/**
    * @ClassName: ServeService
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月13日
    *
    */

public interface ServeService {
	public List<Serve> serveQuery();

	
	    /**
	    * @Title: serveAdd
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param serve    参数
	    * @return void    返回类型
	    * @throws
	    */
	    
	public void serveAdd(Serve serve);


		
		    /**
		    * @Title: serveDelete
		    * @Description: TODO(这里用一句话描述这个方法的作用)
		    * @param @param id    参数
		    * @return void    返回类型
		    * @throws
		    */
		    
		public void serveDelete(int id);


			
			    /**
			    * @Title: serveSub
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param @param id    参数
			    * @return void    返回类型
			    * @throws
			    */
			    
			public void serveSub(int id);

}
