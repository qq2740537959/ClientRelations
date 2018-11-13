package com.znsd.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientWorthDao {
	
	public List<Map<String, Object>> selectClientWorthByPage(@Param(value="clientName") String clientName);
}
