package com.znsd.client.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.znsd.client.bean.Page;
import com.znsd.client.page.Pages;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.vo.DepartmentVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-core.xml")
public class DepartmentMapperDaoTest {

	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void test() {
		Pages page = new Pages();
		page.setCurrentIndexPage(1);
		page.setPageSize(5);
		List<DepartmentVo> list = departmentService.selectDepartmentByPage(page, "总经理666");
		System.out.println("数据"+list);
	}

}
