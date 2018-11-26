package com.znsd.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.vo.ClientVo;

@Repository
public interface ClientResourceMapperDao {
	//按销售代表id查询客户
	public List<ClientVo> selectClientInfoByPage(@Param("staffId") int staffId,@Param("distinguish")String distinguish,@Param("clientNameOrPhone") String clientOrPhone);
	
	//按客户id查询客户信息
	public ClientVo selectClientById(@Param("clientId")int clientId);

	//客户资源信息
	public List<Map<String, Object>> selectAllClientByPage(@Param("allotState")Integer allotState,@Param("conditionName")String conditionName,@Param("condition")String condition);
	
	//客户资源增加
	public Integer addResource(ClientResource resource);
	
	//修改资源
	public Integer updateResource(ClientResource resource);
	
	//查询未分配和正常状态的客户
	public List<Map<String, Object>> selectResourceState(@Param("allotState")Integer allotState,@Param("state")Integer state);
}
