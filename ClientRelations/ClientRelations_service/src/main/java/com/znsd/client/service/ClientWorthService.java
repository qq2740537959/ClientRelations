package com.znsd.client.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ClientWorthService {
	
	public List<Map<String, Object>> selectClientWorthByPage(@Param(value="clientName") String clientName);
}
