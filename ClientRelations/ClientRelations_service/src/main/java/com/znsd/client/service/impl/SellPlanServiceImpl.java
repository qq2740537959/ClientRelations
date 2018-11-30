package com.znsd.client.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.SellPlan;
import com.znsd.client.dao.SellPlanDao;
import com.znsd.client.service.SellPlanService;

@Service
public class SellPlanServiceImpl implements SellPlanService {
	
	@Autowired
	private SellPlanDao dao;
	
	

	@Override
	public void addSellPlan(SellPlan sellPlan) {
		// TODO Auto-generated method stub
		dao.addSellPlan(sellPlan);
	}

	@Override
	public void subSellPlan(String roleName,Integer handleId,Integer planId) {
		// TODO Auto-generated method stub
		dao.subSellPlan(roleName,handleId,planId);
	}

	@Override
	public void delSellPlan(Integer planId) {
		// TODO Auto-generated method stub
		dao.delSellPlan(planId);
	}

	@Override
	public List<Map<String, Object>> selectSellPlanByPage(String roleName, Integer sellingId, String planMonth) {
		// TODO Auto-generated method stub
		return dao.selectSellPlanByPage(roleName,sellingId,planMonth);
	}

	@Override
	public void examineSellPlan(SellPlan sellPlan) {
		// TODO Auto-generated method stub
		dao.examineSellPlan(sellPlan);
	}

	@Override
	public int selectSellDate(String planMonth, Integer sellingId) {
		// TODO Auto-generated method stub
		return dao.selectSellDate(planMonth, sellingId);
	}

	@Override
	public void updateSellPlan(SellPlan sellPlan) {
		// TODO Auto-generated method stub
		dao.updateSellPlan(sellPlan);
	}

}
