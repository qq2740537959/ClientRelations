package com.znsd.client.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.service.ClientService;
import com.znsd.client.vo.ClientVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-core.xml")
public class ClientTest {
	@Autowired
	ClientService service;
	
	@Test  
	public void tests() {
		System.out.println(service);
		ClientResource client = new ClientResource();
		client.setStaffId(1);
		client.setClientName("");
		client.setPhone("13345697832");
		List<ClientVo> clientVo = service.selectClientInfo(client);
		for (ClientVo clientVo2 : clientVo) {
			System.out.println("-=--"+clientVo2.getClientName()+"  "+clientVo2.getStaffName());
		}
	}
	
}
