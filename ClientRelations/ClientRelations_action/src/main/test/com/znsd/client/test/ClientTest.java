package com.znsd.client.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.page.Pages;
import com.znsd.client.service.ClientService;
import com.znsd.client.vo.ClientVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-core.xml")
public class ClientTest {
	@Autowired
	ClientService service;
	
	@Test
	public void tests() {
		Pages page = new Pages();
		page.setCurrentIndexPage(1);
		page.setPageSize(5);
		List<ClientVo> clientVo = service.selectClientInfoByPage(2,null,null,page);
		for (ClientVo clientVo2 : clientVo) {
			System.out.println(clientVo2.getClientName()+"  "+clientVo2.getStaffName());
		}
	}
	
}
