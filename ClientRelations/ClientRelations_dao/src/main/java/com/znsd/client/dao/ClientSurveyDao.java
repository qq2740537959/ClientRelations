package com.znsd.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientSurveyDao {
	public List<Map<String, Object>> selectAllClientSurveyByPage(@Param("clientName")String clientName,@Param("roleId")int roleId,@Param("staffId")int staffId);
}
