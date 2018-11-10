package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Shape;
import com.znsd.client.dao.ContractMapperDao;
import com.znsd.client.service.ContractService;

@Service
public class ContractServiceImp implements ContractService{
	
	@Autowired
	private ContractMapperDao dao;
	
	public List<Shape> selectShape() {
		return dao.selectShape();
	}

}
