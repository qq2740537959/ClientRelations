package com.znsd.client.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.znsd.client.bean.ClientResource;
import com.znsd.client.vo.ClientVo;

@Repository
public interface ClientResourceMapperDao {
	List<ClientVo> selectClientInfo(ClientResource client);
}
