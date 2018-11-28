package com.znsd.client.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.bean.OrderIndent;
import com.znsd.client.bean.Product;
import com.znsd.client.vo.OrderIndentVo;
import com.znsd.client.vo.OrderStatisticsVo;

@Repository
public interface OrderIndentMapperDao {
	//查询订单信息
	public List<OrderIndentVo> selectOrderIndent(@Param("differentiate") String differentiate,@Param("inputSelect") String inputSelect,@Param("dealTime") String dealTime,@Param("status") String status);
	
	//修改订单状态
	public int updateOrderStatus(@Param("status") String status,@Param("orderCode") String orderCode);
	
	//添加订单记录
	public int addOrder(OrderIndent orderIndent);
	
	//订单统计
	public List<OrderStatisticsVo> orderStatistics(@Param("minDate") String minDate,@Param("maxDate") String maxDate);
	
}
