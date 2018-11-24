package com.znsd.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Product;
import com.znsd.client.dao.ProductMapperDao;
import com.znsd.client.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapperDao dao;

	public List<Product> selectProductByPage() {
		//查询所有商品 
		return dao.selectProductByPage();
	}

	public List<Product> selectProductById(List<Integer> list) {
		//查询商品id的所有商品
		return dao.selectProductById(list);
	}
	
}
