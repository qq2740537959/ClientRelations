package com.znsd.client.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Shape;
import com.znsd.client.dao.ContractDao;
import com.znsd.client.service.ContractService;

@Service
public class ContractServiceImp implements ContractService{
	
	@Autowired
	private ContractDao dao;
	
	public List<Shape> selectShape() {
		return dao.selectShape();
	}

}
