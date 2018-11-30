
    /**  
    * @Title: ServeDao.java
    * @Package com.znsd.client.dao
    * @Description: TODO(用一句话描述该文件做什么)
    * @author Administrator
    * @date 2018年11月13日
    * @version V1.0  
    */
    
package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Serve;

/**
    * @ClassName: ServeDao
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月13日
    *
    */
@Repository
public interface ServeDao {

		
		    /**
		    * @Title: serveQuery
		    * @Description: TODO(这里用一句话描述这个方法的作用)
		    * @param @return    参数
		    * @return List<Serve>    返回类型
		    * @throws
		    */
		    
		List<Serve> serveQuery();

			
			    /**
			    * @Title: serveAdd
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param @param serve    参数
			    * @return void    返回类型
			    * @throws
			    */
			    
			void serveAdd(Serve serve);


				
				    /**
				    * @Title: serveDelete
				    * @Description: TODO(这里用一句话描述这个方法的作用)
				    * @param @param id    参数
				    * @return void    返回类型
				    * @throws
				    */
				    
				void serveDelete(Serve serve);


					
					    /**
					    * @Title: serveSub
					    * @Description: TODO(这里用一句话描述这个方法的作用)
					    * @param @param id    参数
					    * @return void    返回类型
					    * @throws
					    */
					    
					void serveSub(Serve serve);


						
						    /**
						    * @Title: serveUpdate
						    * @Description: TODO(这里用一句话描述这个方法的作用)
						    * @param @param serve    参数
						    * @return void    返回类型
						    * @throws
						    */
						    
						void serveUpdate(Serve serve);


}
