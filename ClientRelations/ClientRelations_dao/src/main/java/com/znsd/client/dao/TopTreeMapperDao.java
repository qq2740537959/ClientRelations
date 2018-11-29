package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.TopTree;

@Repository
public interface TopTreeMapperDao {
	//查询省份
	public List<TopTree> selectToptreeAll();
	//查询市、区
	public List<TopTree> selectToptreeByPId(int id);
	//查询省、市、区
	public List<TopTree> selectTopeByPId(List<Integer> list);
}
