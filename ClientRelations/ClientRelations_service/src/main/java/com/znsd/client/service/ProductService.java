package com.znsd.client.service;

import java.util.List;

import com.znsd.client.bean.Product;
import com.znsd.client.page.Pages;

public interface ProductService {
	//查询所有商品 
	public List<Product> selectProductByPage();
	
	//查询商品id的所有商品
	public List<Product> selectProductById(List<Integer> list);
}
