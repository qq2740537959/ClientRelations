package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.Statistic;

public interface StatisticService {
	//查询构成记录
	public List<Statistic>constituteListByPage(String startTime);
	//查询贡献记录
	public List<Statistic>contributionListByPage(String startTime,String endTime);
	//查询流失记录
	public List<Statistic>lossListByPage(String startTime);
	//查询服务记录
	public List<Statistic>serviceListByPage(String startTime,String endTime);
}
