package com.znsd.client.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.OrderIndent;
import com.znsd.client.bean.SellPlan;
import com.znsd.client.dao.OrderIndentMapperDao;
import com.znsd.client.service.OrderIndentService;
import com.znsd.client.vo.OrderIndentVo;
import com.znsd.client.vo.OrderStatisticsVo;

@Service
public class OrderIndentServiceImpl implements OrderIndentService{
	
	@Autowired
	private OrderIndentMapperDao dao;
	
	public List<OrderIndentVo> selectOrderIndent(String staffId,String differentiate, String inputSelect, String dealTime,
			String status) {
		//查询订单信息
		return dao.selectOrderIndent(staffId,differentiate, inputSelect, dealTime, status);
	}

	public int updateOrderStatus(String status,String orderCode) {
		//修改订单状态
		return dao.updateOrderStatus(status,orderCode);
	}

	public int addOrder(OrderIndent orderIndent) {
		//添加订单记录
		return dao.addOrder(orderIndent);
	}

	public List<OrderStatisticsVo> orderStatistics(String staffId,String minDate,String maxDate) {
		// 订单统计
		return dao.orderStatistics(staffId,minDate,maxDate);
	}

	@Override
	public int updateOrderByIdStatus(String status, String id) {
		//修改订单状态2
		return dao.updateOrderByIdStatus(status, id);
	}

}
