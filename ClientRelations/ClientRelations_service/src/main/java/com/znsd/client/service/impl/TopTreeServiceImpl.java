package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.TopTree;
import com.znsd.client.dao.TopTreeMapperDao;
import com.znsd.client.service.TopTreeService;
@Service
public class TopTreeServiceImpl implements TopTreeService{
	@Autowired
	private TopTreeMapperDao dao;
	public List<TopTree> selectToptreeAll() {
		//查询省份
		return dao.selectToptreeAll();
	}
	public List<TopTree> selectToptreeByPId(int id) {
		//查询市、区
		return dao.selectToptreeByPId(id);
	}
	public List<TopTree> selectTopeByPId(List<Integer> list) {
		//查询省、市、区
		return dao.selectTopeByPId(list);
	}

}
