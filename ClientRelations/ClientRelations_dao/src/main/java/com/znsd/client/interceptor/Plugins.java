package com.znsd.client.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import com.znsd.client.page.Pages;


@Intercepts(
		{
		@Signature(
		  type= StatementHandler.class,
		  method = "prepare",
		  args = {
				  Connection.class,
				  Integer.class
				  }
		  )
		}
)	
public class Plugins implements Interceptor{
	
	public Object intercept(Invocation invocation) throws Throwable {
		// 首先获取连接
		Connection conn = (Connection)invocation.getArgs()[0];
		// 通过Connection可以执行JDBC操作
		
		// 获取到invocation执行的目标对象，实际就是获取RoutingStatementHandler
		StatementHandler sh = (StatementHandler) invocation.getTarget();
		// 获取StatementHandler的元数据，元数据就是对象的属性、方法。。。。
		MetaObject mo = SystemMetaObject.forObject(sh);
		
		// 通过元数据，获取到它里面的mappedStatement属性
		MappedStatement ms = (MappedStatement) mo.getValue("delegate.mappedStatement");
		
		BoundSql boundSql = sh.getBoundSql();
		String sql = boundSql.getSql();
		
		String sqlId = ms.getId();
		if(sqlId.endsWith("ByPage")) {
			
			Map<String, Object> map = (Map<String, Object>) boundSql.getParameterObject();
			Pages page = (Pages) map.get("arg0");
			
			// 分页处理
			String limitSql = "select count(*) from (" + sql + ") as s";
			PreparedStatement par = conn.prepareStatement(limitSql);
			
			//获取mapper文件中当前查询语句的配置信息
            MappedStatement mappedStatement = (MappedStatement) mo.getValue("delegate.mappedStatement");
            //获取所有配置Configuration
            Configuration configuration = mappedStatement.getConfiguration();
            //构建统计总记录数的BoundSql
            BoundSql countBoundSql = new BoundSql(configuration, limitSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            //构建ParameterHandler，用于设置统计sql的参数
            ParameterHandler  parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
            //设置总数sql的参数
            parameterHandler.setParameters(par);
			
			ResultSet result = par.executeQuery();
			int countPageSize = 0;
			if(result.next()) {
				//总条数
				countPageSize=result.getInt(1);
			}
			
			//总页数
			page.setTotalIndexPage(countPageSize%page.getPageSize()==0?countPageSize/page.getPageSize():countPageSize/page.getPageSize()+1);
			//总条数
			page.setTotalPageSize(countPageSize);
			sql += " limit "+((page.getCurrentIndexPage()-1)*page.getPageSize())+","+page.getPageSize()+"";
			System.out.println("sql:"+sql);
			mo.setValue("delegate.boundSql.sql", sql);
		}
		return invocation.proceed();
	}
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}

}
