package com.znsd.client.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.znsd.client.dao.ClientSurveyDao;
import com.znsd.client.service.ClientSurveyService;

@Service
public class ClientSurveyServiceImpl implements ClientSurveyService {

	@Autowired
	private ClientSurveyDao dao;
	
	@Override
	public Map<String, Object> selectAllClientSurveyByPage(String clientName, int roleId, int staffId,Integer page,Integer limit) {
		Map<String, Object> model = new HashMap<String, Object>();
		Page<Object> pages = PageHelper.startPage(page, limit);
		List<Map<String, Object>> list = dao.selectAllClientSurveyByPage(clientName, roleId, staffId);
		for (Map<String, Object> map : list) {
			Integer quality = Integer.valueOf((String)map.get("qualityPleased"));
			Integer serve = Integer.valueOf((String)map.get("servePleased"));
			Integer benefit = Integer.valueOf((String)map.get("benefitPleased"));
			map.put("clientType", map.get("clientType")+"客户");
			map.put("qualityPleased", map.get("qualityPleased")+"%");
			map.put("servePleased", map.get("servePleased")+"%");
			map.put("benefitPleased", map.get("benefitPleased")+"%");
			map.put("totalPleased", ((quality+serve+benefit)/3)+"%");
		}
		model.put("code", 0);
		model.put("data", list);
		model.put("page", page); 
		model.put("limit", limit);
		model.put("count", pages.getTotal());
		return model;
	}

}
