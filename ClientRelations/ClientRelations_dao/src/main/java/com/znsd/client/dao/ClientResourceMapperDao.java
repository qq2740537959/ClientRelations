package com.znsd.client.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.page.Pages;
import com.znsd.client.vo.ClientVo;

@Repository
public interface ClientResourceMapperDao {
	//按销售代表id查询客户
	public List<ClientVo> selectClientInfoByPage(@Param("staffId") int staffId,@Param("distinguish")String distinguish,@Param("clientNameOrPhone") String clientOrPhone);
	
	//按客户id查询客户信息
	public ClientVo selectClientById(@Param("clientId")int clientId);

}
