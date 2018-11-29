package com.znsd.client.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.DevelopPlan;
import com.znsd.client.dao.DevelopPlanDao;
import com.znsd.client.service.DevelopPlanService;

@Service
public class DevelopPlanImpl implements DevelopPlanService {

	@Autowired
	private DevelopPlanDao dao;
	
	@Override
	public List<DevelopPlan> selectDevelopPlan(String month) {
		return dao.selectDevelopPlan(month);
	}

	@Override
	public Integer deleteDevelopPlan(Integer planId) {
		return dao.deleteDevelopPlan(planId);
	}

	@Override
	public Integer insertDevelopPlan(DevelopPlan plan) {
		return dao.insertDevelopPlan(plan);
	}

	@Override
	public Integer updateDevelopPlan(DevelopPlan plan) {
		return dao.updateDevelopPlan(plan);
	}

	@Override
	public List<Map<String, Object>> selectClientName() {
		return dao.selectClientName();
	}
	
}

