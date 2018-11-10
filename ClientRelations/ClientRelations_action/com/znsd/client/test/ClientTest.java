package com.znsd.client.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.znsd.client.service.ClientService;
import com.znsd.client.vo.ClientVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-core.xml")
public class ClientTest {
	@Autowired
	ClientService service;
	
	@Test
	public void tests() {
		List<ClientVo> clientVo = service.selectClientInfo(1);
		for (ClientVo clientVo2 : clientVo) {
			System.out.println(clientVo2);
		}
	}
	
}
