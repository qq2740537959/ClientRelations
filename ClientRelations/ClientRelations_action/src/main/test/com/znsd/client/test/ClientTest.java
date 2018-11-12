package com.znsd.client.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.znsd.client.bean.Product;
import com.znsd.client.service.ClientService;
import com.znsd.client.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-core.xml")
public class ClientTest {
	@Autowired
	ClientService service;
	@Autowired
	ProductService productService;
	@Test
	public void tests() {
		/*Pages page = new Pages();
		page.setCurrentIndexPage(1);
		page.setPageSize(5);*/
	/*	Page<Object> page = PageHelper.startPage(1, 5);
		List<ClientVo> clientVo = service.selectClientInfoByPage(1,null,null);
		for (ClientVo clientVo2 : clientVo) {
			System.out.println(clientVo2.toString());
		}*/
	/*	ClientVo clientVo = service.selectClientById(1);
		System.out.println(clientVo);*/
		
		//List<Product> productList = productService.selectProductByPage();
		String aa = "1,2,3,";
		String [] ary = aa.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ary.length; i++) {
			list.add(Integer.valueOf(ary[i]));
		}
		List<Product> productList = productService.selectProductById(list);
		for (Product product : productList) {
			System.out.println("------------"+product);
		}
	}
	
}
