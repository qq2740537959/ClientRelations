package com.znsd.client.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.znsd.client.page.Pages;
import com.znsd.client.vo.ClientVo;

@Repository
public interface ClientResourceMapperDao {
	public List<ClientVo> selectClientInfoByPage(@Param("staffId") int staffId,@Param("clientName")String clientName,@Param("phone") String phone,Pages page);
}
