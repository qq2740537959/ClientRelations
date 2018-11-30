package com.znsd.client.controller;

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
import com.znsd.client.bean.Notice;
import com.znsd.client.service.NoticeService;
import com.znsd.client.vo.NoticeVo;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeBiz;
	
	//分页条件查询员工信息
	@RequestMapping("/selectNoticeByPage")
	@ResponseBody
	public Map<String, Object> selectStaffByPage(@RequestParam("page")Integer page,@RequestParam("limit") Integer limit,Notice notice){
		System.out.println(notice+"----notice");
		Map<String, Object> map = new HashMap<>();
		Page<Object> pages = PageHelper.startPage(page,limit);
		List<NoticeVo> list = noticeBiz.selectNoticeByPage(notice);
		map.put("code", 0);
		map.put("msg", "查询成功");
		map.put("data", list);
		map.put("count", pages.getTotal());
		return map;
	}
	
	//根据公告Id删除该公告
	@RequestMapping("/deleteNoticeById")
	@ResponseBody
	public Map<String, Object> deleteNoticeById(@RequestParam("nArray")String nArray){
		Map<String, Object> map = new HashMap<>();
		String[] spli = nArray.split(",");
		/*System.out.println(spli);
		int[] nId= new int[spli.length];
        for (int i = 0; i < spli.length; i++) {
        	nId[i]=Integer.parseInt(spli[i]);
        }
        System.out.println(nId+"----这是什么"+nId[0]);*/
		noticeBiz.deleteNoticeById(spli);
		map.put("code", 1);
		map.put("msg", "删除成功！");
		return map;
	}
	
}
