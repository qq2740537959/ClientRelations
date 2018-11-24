package com.znsd.client.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.ClientResource;
import com.znsd.client.bean.Product;
import com.znsd.client.service.ClientService;
import com.znsd.client.service.ClientWorthService;
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
	
	@Test
	public void testClientAll() {
		Page<Object> pages = PageHelper.startPage(1, 5);
		List<Map<String, Object>> list = service.selectAllClientByPage(0,"clientName","隋炀帝");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	//add 增加资源
	@Test
	public void testAddResource() {
		
		ClientResource resource = new ClientResource();
		resource.setContactAddress("常山辉煌道普股街");
		resource.setClientName("戏谑精");
		resource.setClientType("普通");
		resource.setFamilyPhone("16523156498");
		resource.setEmail("jang@cing.com");
		resource.setInTime(new Date());
		resource.setInTime(new Date());
		resource.setPhone("19654842191");
		resource.setRemark("备注");
		resource.setSex("妖");
		resource.setWorkPhone("94149-4894");
		
		resource.setConsumptionTimes(0);
		resource.setTotalConsumptionAmount(0.0);
		
		Integer count = service.addResource(resource);
		if (count > 0) {
			System.out.println(count+"增加成功");
		}
		System.out.println("数据的增加====="+count);
	}
	
	@Autowired
	private ClientWorthService worthService;
	
	@Test
	public void testclientworth() {
		Page<Object> pages = PageHelper.startPage(1, 5);
		List<Map<String, Object>> list = worthService.selectClientWorthByPage("邓");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
}
