package com.znsd.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Statistic;

@Repository
public interface StatisticDao {

	public List<Statistic> constituteListByPage(@Param(value="startTime")String startTime);

	public List<Statistic> contributionListByPage(@Param(value="startTime")String startTime,@Param(value="endTime")String endTime);

	public List<Statistic> lossListByPage(@Param(value="startTime")String startTime);

	public List<Statistic> serviceListByPage(@Param(value="startTime")String startTime,@Param(value="endTime")String endTime);

}
