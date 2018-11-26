package com.znsd.client.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.service.DepartmentService;
import com.znsd.client.vo.DepartmentVo;

@Controller
public class DepartmentAction {

	@Autowired
	private DepartmentService departmentBiz;
	
	//分页条件查询组织结构
	@RequestMapping("/queryDepartmentByPage")
	@ResponseBody
	public Map<String, Object> queryDepartmentByPage(@RequestParam(value="departmentFullname",required=false) String departmentFullname,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit) {
		Map<String, Object> map = new HashMap<>();
		Page<Object> pages = PageHelper.startPage(page,limit);
		List<DepartmentVo> list = departmentBiz.selectDepartmentByPage(departmentFullname);
		map.put("code", 0);
		map.put("msg", "查询成功");
		map.put("data", list);
		map.put("count", pages.getTotal());
		return map;
	}
	
}
