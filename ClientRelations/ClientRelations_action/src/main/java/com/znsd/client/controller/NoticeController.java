package com.znsd.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.bean.Notice;
import com.znsd.client.service.NoticeService;
import com.znsd.client.vo.NoticeVo;
import com.znsd.client.vo.StaffLoginVo;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeBiz;
	
	//分页条件查询员工信息
	@RequestMapping("/selectNoticeByPage")
	@ResponseBody
	public Map<String, Object> selectStaffByPage(@RequestParam("page")Integer page,@RequestParam("limit") Integer limit,Notice notice){
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
		noticeBiz.deleteNoticeById(spli);
		map.put("code", 1);
		map.put("msg", "删除成功！");
		return map;
	}
	
	//修改公告跳转页面
	@RequestMapping("/updateIntoPage")
	public String selectNoticeById(@RequestParam("noticeId") int noticeId,ModelMap map) {
		map.put("notice", noticeBiz.selectNoticeById(noticeId));
		return "admin/views/systemManager/addOrUpdateNotice.jsp";
	}
	
	//增加或者修改公告信息
	@RequestMapping("/addOrUpdateNotice")
	@ResponseBody
	public Map<String, Object> addOrUpdateNotice(Notice notice,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		System.out.println(notice+"--床来的");
		if (notice.getNoticeId() != 0) {
			noticeBiz.updateNoticeById(notice);
			map.put("msg", "修改成功！");
		}else {
			StaffLoginVo staffLoginVo = (StaffLoginVo) session.getAttribute("userInfo");
			notice.setReleasePerson(staffLoginVo.getStaffId());
			notice.setReleaseTime(new Date());
			noticeBiz.addNotice(notice);
			map.put("msg", "增加成功！");
		}
		map.put("code", "1");
		return map;
	}
	
}
