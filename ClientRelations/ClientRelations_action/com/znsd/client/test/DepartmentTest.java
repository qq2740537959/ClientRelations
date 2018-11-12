package com.znsd.client.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.znsd.client.bean.Page;
import com.znsd.client.service.ClientService;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.vo.ClientVo;
import com.znsd.client.vo.DepartmentVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-core.xml")
public class ClientTest {
	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void tests() {
		Page page = new Page();
		page.setCurrentPage(1);
		page.setPageSize(5);
		List<DepartmentVo> clientVo = departmentService.selectDepartmentByPage(page, "%总经理%")
		
	}
	
}
