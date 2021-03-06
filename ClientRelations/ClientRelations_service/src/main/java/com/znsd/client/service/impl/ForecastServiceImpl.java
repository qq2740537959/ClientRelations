package com.znsd.client.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Forecast;
import com.znsd.client.bean.Hap;
import com.znsd.client.dao.ForecastDao;
import com.znsd.client.service.ForecastService;

@Service
public class ForecastServiceImpl implements ForecastService {
	@Autowired
	private ForecastDao dao;

	@Override
	public void addForecast(Forecast forecast) {
		// TODO Auto-generated method stub
		dao.addForecast(forecast);
	}

	@Override
	public int selectDateClientNumber(Integer branceId,String referDate) {
		// TODO Auto-generated method stub
		return dao.selectDateClientNumber(branceId,referDate);
	}

	@Override
	public int selectDateStaffNumber(Integer branceId,String referDate) {
		// TODO Auto-generated method stub
		return dao.selectDateStaffNumber(branceId,referDate);
	}

	@Override
	public List<Map<String, Object>> selectForecastByPage(String startTime) {
		// TODO Auto-generated method stub
		return dao.selectForecastByPage(startTime);
	}

}
