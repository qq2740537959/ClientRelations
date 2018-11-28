package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.Product;

public interface ProductService {
	//查询所有商品 
	public List<Product> selectProductByPage();
	
	//查询商品id的所有商品
	public List<Product> selectProductById(List<Integer> list);
	
	//购买后数量减少
	public int reduceProductNumber(Integer productId,Integer number);
}
