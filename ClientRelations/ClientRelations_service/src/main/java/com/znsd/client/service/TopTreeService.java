package com.znsd.client.service;

import java.util.List;
import com.znsd.client.bean.TopTree;

public interface TopTreeService {
	//查询省份
	public List<TopTree> selectToptreeAll();
	//查询市、区
	public List<TopTree> selectToptreeByPId(int id);
	//查询省、市、区
	public List<TopTree> selectTopeByPId(List<Integer> list);
}
