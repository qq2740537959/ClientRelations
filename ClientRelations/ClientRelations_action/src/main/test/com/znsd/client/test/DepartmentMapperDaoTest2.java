package com.znsd.client.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.znsd.client.service.OrderIndentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-core.xml")
public class DepartmentMapperDaoTest2 {

	@Autowired
	OrderIndentService orderIndentService;
	
	@Test
	public void test() {
		System.out.println(orderIndentService.updateOrderByIdStatus("已完成", "1"));
	}

}
