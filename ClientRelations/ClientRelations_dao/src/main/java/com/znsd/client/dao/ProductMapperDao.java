package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.Product;

@Repository
public interface ProductMapperDao {
	//查询所有商品 
	public List<Product> selectProductByPage();
	
	//查询商品id的所有商品
	public List<Product> selectProductById(List<Integer> list);
}
