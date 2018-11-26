package com.znsd.client.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znsd.client.bean.OrderIndent;
import com.znsd.client.vo.OrderIndentVo;
import com.znsd.client.vo.OrderStatisticsVo;

public interface OrderIndentService {
	//查询订单信息
	public List<OrderIndentVo> selectOrderIndent(String differentiate,String inputSelect,String dealTime,String status);
	//修改订单状态
	public int updateOrderStatus(String status,String orderCode);
	//添加订单记录
	public int addOrder(OrderIndent orderIndent);
	//订单统计
	public List<OrderStatisticsVo> orderStatistics(String minDate,String max);
}