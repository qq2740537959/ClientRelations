package com.znsd.client.service;

import java.util.Map;

public interface ClientSurveyService {
	
	public Map<String, Object> selectAllClientSurveyByPage(String clientName,int roleId,int staffId,Integer page,Integer limit);
}
