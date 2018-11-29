package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Statistic;
import com.znsd.client.dao.StatisticDao;
import com.znsd.client.service.StatisticService;

@Service
public class StatisticServiceImpl implements StatisticService {
	@Autowired
	private StatisticDao statisticDao;
	
	public List<Statistic> constituteListByPage(String startTime) {
		// TODO Auto-generated method stub
		return statisticDao.constituteListByPage(startTime);
	}

	public List<Statistic> contributionListByPage(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return statisticDao.contributionListByPage(startTime,endTime);
	}

	public List<Statistic> lossListByPage(String startTime) {
		// TODO Auto-generated method stub
		return statisticDao.lossListByPage(startTime);
	}

	public List<Statistic> serviceListByPage(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return statisticDao.serviceListByPage(startTime,endTime);
	}

}
